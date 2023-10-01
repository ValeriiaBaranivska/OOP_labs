import java.util.regex.Pattern;

public class StringCalculator {
    public static int Add(String numbers) {
        String[] numberArray;
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ","; // Default delimiter
        String numbersWithoutDelimiter = numbers;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            if (delimiterEndIndex != -1) {
                delimiter = numbers.substring(2, delimiterEndIndex);
                numbersWithoutDelimiter = numbers.substring(delimiterEndIndex + 1);
            }
        }

        numberArray = numbersWithoutDelimiter.split("[" + delimiter + ",\\n]");

        boolean hasInvalidCharacters = false; // Track if there are invalid characters
        for (String num : numberArray) {
            if (!num.matches("^-?\\d+(\\.\\d+)?$")) {
                hasInvalidCharacters = true;
                break; // Exit the loop once invalid characters are found
            }
            if (numbers.contains(",\n")) {
                hasInvalidCharacters = true;
                break; // Exit the loop once invalid characters are found
            }
        }
        if (hasInvalidCharacters) {
            System.out.println("Input contains invalid characters!");
            return 0;
        }

        int sum = 0;
        for (String num : numberArray) {
            sum += Integer.parseInt(num); // Sum all valid numbers
        }
        return sum;
    }
}
