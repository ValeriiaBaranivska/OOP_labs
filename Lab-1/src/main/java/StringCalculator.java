public class StringCalculator {
    public static int Add(String numbers) {
        String[] numberArray;
        if (numbers.isEmpty()) {
            return 0;
        }
        numberArray = numbers.split(",|\\n");

        boolean hasInvalidCharacters = false; // Track if there are invalid characters

        for (String num : numberArray) {
            if (!num.matches("^-?\\d+(\\.\\d+)?$")) {
                hasInvalidCharacters = true;
                break; // Exit the loop once invalid characters are found
            }
            if (numbers.contains(",\n")){
                hasInvalidCharacters = true;
                break; // Exit the loop once invalid characters are found
            }
        }
        if (hasInvalidCharacters) {
            System.out.println("Input contains invalid characters!");
            return 0; // Return 0 for invalid input

        }

        int sum = 0;
        for (String num : numberArray) {
            sum += Integer.parseInt(num); // Sum all valid numbers
        }
        return sum;
    }
}
