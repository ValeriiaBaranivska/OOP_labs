import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        System.out.println("\n\n ~ ~ ~ String Calculator TDD ~ ~ ~");
        System.out.println("\t Valeriia Baranivska KM-23\n");
        System.out.println("1. Enter numbers by comma(any length)");

        StringCalculator calculator = new StringCalculator();
        Scanner myObj = new Scanner(System.in);
        while(true){
            System.out.println("Enter your line:");
            String input = myObj.nextLine();
            if (input.equals("exit")) {
                System.out.println("Have a nice day!\n\n");
                break;
            }
            int result = calculator.Add(input);
            System.out.println("Result:" + result);

        }
    }
}
