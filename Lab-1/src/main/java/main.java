import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        System.out.println("\n\n ~ ~ ~ String Calculator TDD ~ ~ ~");
        System.out.println("\t Valeriia Baranivska KM-23\n");
        System.out.println("1. Enter numbers by comma(any length)");
        System.out.println("2. Enter numbers by \\n ");
        System.out.println("3. Pattern to enter //[delimiter]\\n[numbers]");
        System.out.println("4. Negative numbers are not allowed!");
        System.out.println("5. Numbers more than 1000 ignored");
        System.out.println("6. Pattern to enter //[delimiter]\\n (delimiter could be of any length) ");
        System.out.println("7. Enter some delimiters ");
        System.out.println("8. Check the input of multiple delimiters of any length ");
        StringCalculator calculator = new StringCalculator();
        Scanner myObj = new Scanner(System.in);
        while(true){
            System.out.println("Enter your line:");
            String input = myObj.nextLine();
            input = input.replace("\\n", "\n");
            if (input.equals("exit")) {
                System.out.println("Have a nice day!\n\n");
                break;
            }
            int result = calculator.Add(input);
            System.out.println("Result:" + result);

        }
    }
}
