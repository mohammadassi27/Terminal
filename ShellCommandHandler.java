import java.io.File;
import java.io.IOException;

    public class ShellCommandHandler {
        private File currentDirectory;

        public ShellCommandHandler() {
            this.currentDirectory = new File(System.getProperty("user.dir"));
        }

        public void printWorkingDirectory() {
            System.out.println(currentDirectory.getAbsolutePath());
        }

        public void listDirectory() {
            File[] files = currentDirectory.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
                }
            } else {
                System.out.println("לא ניתן להציג את תוכן התיקייה.");
            }
        }

        public void changeDirectory(String name) {
            if (name.equals("..")) {
                currentDirectory = currentDirectory.getParentFile();
            } else {
                File newDir = new File(currentDirectory, name);
                if (newDir.exists() && newDir.isDirectory()) {
                    currentDirectory = newDir;
                } else {
                    System.out.println("התיקייה לא קיימת.");
                }
            }
        }

        public void makeDirectory(String name) {
            File newDir = new File(currentDirectory, name);
            if (!newDir.exists()) {
                if (newDir.mkdir()) {
                    System.out.println("התיקייה נוצרה בהצלחה.");
                } else {
                    System.out.println("שגיאה ביצירת התיקייה.");
                }
            } else {
                System.out.println("התיקייה כבר קיימת.");
            }
        }

        public void createFile(String name) {
            File newFile = new File(currentDirectory, name);
            if (!newFile.exists()) {
                try {
                    if (newFile.createNewFile()) {
                        System.out.println("הקובץ נוצר בהצלחה.");
                    } else {
                        System.out.println("שגיאה ביצירת הקובץ.");
                    }
                } catch (IOException e) {
                    System.out.println("שגיאה: " + e.getMessage());
                }
            } else {
                System.out.println("הקובץ כבר קיים.");
            }
        }

        public void printHelp() {
            System.out.println("Available commands:");
            System.out.println("pwd - הצגת התיקייה הנוכחית");
            System.out.println("ls - הצגת הקבצים בתיקייה הנוכחית");
            System.out.println("cd <folder> - מעבר לתיקייה");
            System.out.println("mkdir <folder> - יצירת תיקייה");
            System.out.println("create <file> - יצירת קובץ");
            System.out.println("help - עזרה");
            System.out.println("exit - יציאה מהתוכנית");
        }

        public File getCurrentDirectory() {
            return currentDirectory;
        }
    }
