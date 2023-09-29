public class StringCalculator {
    public static int Add(String numbers) {
        String[] numberArray;
        if (numbers.isEmpty()) {
            return 0;
        }
        numberArray = numbers.split(",");

        boolean hasInvalidCharacters = false; // Track if there are invalid characters

        for (String num : numberArray) {
            if (!num.matches("^\\d+$")) {
                hasInvalidCharacters = true;
                break; // Exit the loop once invalid characters are found
            }
        }

        if (hasInvalidCharacters) {
            System.out.println("Input contains invalid characters.");
            return 0; // Return 0 for invalid input
        }

        if (numberArray.length == 1) {
            return Integer.parseInt(numberArray[0]);
        } else if (numberArray.length == 2) {
            int num1 = Integer.parseInt(numberArray[0]);
            int num2 = Integer.parseInt(numberArray[1]);
            return num1 + num2;
        } else {
            System.out.println("Too many numbers");
            return 0; // Return 0 for cases with too many numbers
        }
    }
}
