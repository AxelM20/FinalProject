import java.util.Scanner;

public class InputValidator {
    public static int getIntInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.next();
        try {
            int value = Integer.parseInt(input);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Please enter a number between " + min + " and " + max);
                return getIntInput(prompt, min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Try again.");
            return getIntInput(prompt, min, max);
        }
    }
} 
