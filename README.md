1. איך יוצרים תיקייה בג'אווה?
   כדי ליצור תיקייה, נשתמש במחלקה File ונפעיל את הפעולה mkdir() על אובייקט עם הנתיב הרצוי.

דוגמת קוד :
import java.io.File;

public class Main {
public static void main(String[] args) {
File folder = new File("myFolder");
if (folder.mkdir()) {
System.out.println("המַחְלֶקֶת נוצרה בהצלחה");
} else {
System.out.println("נכשל ביצירת התיקייה");
}
}
}

קישור :
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#mkdir--

2. איך יוצרים קובץ בג'אווה?
   נשתמש במחלקה File ובשיטה createNewFile(). השיטה זורקת חריגה ולכן יש להשתמש ב־try-catch.

דוגמת קוד :
import java.io.File;
import java.io.IOException;

public class Main {
public static void main(String[] args) {
File file = new File("example.txt");
try {
if (file.createNewFile()) {
System.out.println("הקובץ נוצר בהצלחה");
} else {
System.out.println("הקובץ כבר קיים");
}
} catch (IOException e) {
System.out.println("שגיאה: " + e.getMessage());
}
}
}

קישור  :
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#createNewFile--

3. איך בודקים אם קובץ או תיקייה קיימים?
   נשתמש בשיטה exists() כדי לבדוק אם הקובץ או התיקייה קיימים במערכת הקבצים.

דוגמת קוד :
import java.io.File;

public class Main {
public static void main(String[] args) {
File file = new File("example.txt");
if (file.exists()) {
System.out.println("הקובץ או התיקייה קיימים");
} else {
System.out.println("הקובץ או התיקייה לא קיימים");
}
}
}

קישור  :
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#exists--





4. איך מציגים את תוכן תיקייה?
   נשתמש בשיטה listFiles() או list() כדי לקבל מערך של הקבצים/תיקיות שבתוך התיקייה.

דוגמת קוד :
import java.io.File;

public class Main {
public static void main(String[] args) {
File folder = new File("myFolder");
File[] files = folder.listFiles();
if (files != null) {
for (File f : files) {
System.out.println(f.getName());
}
} else {
System.out.println("התיקייה לא קיימת או ריקה");
}
}
}

קישור  :
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#listFiles--


5. (רשות) מה ההבדל בין File ל-Path?
   File היא מחלקה ותיקה בג'אווה. Path היא חלק מהחבילה החדשה NIO ומציעה עבודה מתקדמת עם קבצים ונתיבים.

דוגמת קוד :
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
public static void main(String[] args) {
Path path = Paths.get("example.txt");
System.out.println("שם הקובץ: " + path.getFileName());
}
}

קישור  :
https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html


____________________________________________________________________________________________________________________________________________________________________________________________________________________



MiniShell - פרויקט מסוף פשוט בג'אווה

תיאור כללי של הפרויקט  
פרויקט זה מדמה מסוף (Terminal) בסיסי בג'אווה. המשתמש יכול להקליד פקודות כמו:  
`pwd`, `ls`, `cd`, `mkdir`, `touch`, `help`, `exit`  
ולקבל פלט מתאים, בדומה למסוף אמיתי.  

מטרת התרגיל היא לתרגל :
עבודה עם קבצים ותיקיות ב-Java
תכנות מונחה עצמים (OOP)
קלט/פלט מול המשתמש
תיעוד קוד ו-README
שימוש ב-Git ו-GitHub

כיצד לקמפל ולהריץ

1- פתח את הטרמינל בתיקיית `src`
2- קמפל את הקוד:
javac MiniShell.java ShellCommandHandler.java
3- הרץ את התוכנית:
java MiniShell

דוגמת הרצה :
/Users/user/Desktop> mkdir myfolder
התיקייה נוצרה בהצלחה.

/Users/user/Desktop> cd myfolder
/Users/user/Desktop/myfolder> touch hello.txt
הקובץ נוצר בהצלחה.

/Users/user/Desktop/myfolder> ls
hello.txt

/Users/user/Desktop/myfolder> pwd
/Users/user/Desktop/myfolder

/Users/user/Desktop/myfolder> help
הפקודות הנתמכות:

pwd

ls

cd <folder>

mkdir <name>

touch <filename>

help

exit

/Users/user/Desktop/myfolder> exit
להתראות!

הערות בקוד : 


// מציג את הנתיב הנוכחי
public void printWorkingDirectory() {
    System.out.println(currentDirectory.getAbsolutePath());
}

// יוצר תיקייה חדשה בשם שנמסר
public void makeDirectory(String name) {
    File newDir = new File(currentDirectory, name);
    if (newDir.mkdir()) {
        System.out.println("התיקייה נוצרה בהצלחה.");
    } else {
        System.out.println("שגיאה ביצירת התיקייה.");
    }
}




