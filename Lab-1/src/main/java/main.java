import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner myObj = new Scanner(System.in);
        while(true){
            System.out.println("Enter 2 numbers by koma:");
            String input = myObj.nextLine();
            int result = calculator.Add(input);
            System.out.println("Result:" + result);
        }

    }
}
