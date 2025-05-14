import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler handler = new ShellCommandHandler();

        while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();

            // نفصل الأمر عن المعامل (إن وجد)
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "exit":
                    scanner.close(); // نغلق الـ Scanner هنا فقط
                    System.out.println("Bye!");
                    return;

                case "pwd":
                    handler.printWorkingDirectory();
                    break;

                case "ls":
                    handler.listDirectory();
                    break;

                case "cd":
                    if (!argument.isEmpty()) {
                        handler.changeDirectory(argument);
                    } else {
                        System.out.println("Usage: cd <folder>");
                    }
                    break;

                case "mkdir":
                    if (!argument.isEmpty()) {
                        handler.makeDirectory(argument);
                    } else {
                        System.out.println("Usage: mkdir <folder>");
                    }
                    break;

                case "create":
                    if (!argument.isEmpty()) {
                        handler.createFile(argument);
                    } else {
                        System.out.println("Usage: create <filename>");
                    }
                    break;

                case "help":
                    handler.printHelp();
                    break;

                default:
                    System.out.println("Unknown command. Type 'help' to see available commands.");
                    break;
            }
        }
    }
}
