import java.util.Scanner;

class InputThread extends Thread {
    private Scanner scanner;
    private String userInput;

    public InputThread() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            userInput = scanner.nextLine();
        }
    }

    public boolean hasInput() {
        return userInput != null;
    }

    public String getInput() {
        String input = userInput;
        userInput = null;
        return input;
    }
}