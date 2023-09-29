public class StringCalculator {
    public static int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String[] numberArray = numbers.split(",");
            if (numberArray.length == 1) {
                return Integer.parseInt(numberArray[0]);
            } else if (numberArray.length == 2) {
                int num1 = Integer.parseInt(numberArray[0]);
                int num2 = Integer.parseInt(numberArray[1]);
                return num1 + num2;
            } else {
                // Handle more than two numbers if needed
                throw new IllegalArgumentException("Too many numbers");
            }
        }
    }
}

