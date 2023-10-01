import java.util.List;
import java.util.ArrayList;


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
        List<Integer> negativeNum = new ArrayList<>();
        for (String num : numberArray) {
            int intValue = Integer.parseInt(num);
            if (intValue < 0) {
                negativeNum.add(intValue);
            } else if(intValue < 1001){
                sum += intValue; // Sum all valid numbers
            }
        }
        if (!negativeNum.isEmpty()) {
            System.out.println("Negative numbers are not allowed: " + negativeNum);
            return 0;
        }else {
            return sum;
        }
    }
}
