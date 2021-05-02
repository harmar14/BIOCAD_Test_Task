import java.util.*;

public class FibonacciAlgorithm {

    public static void main(String[] args) {
        System.out.println("Введите число чисел последовательности:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int num1 = 0;
        if (amount >= 1){
            System.out.print(num1 + " ");
        }
        int num2 = 1;
        if (amount >= 2){
            System.out.print(num2 + " ");
        }
        int num;
        if (amount >= 3){
            for (int i = 2; i < amount; i++) {
                num = num1 + num2;
                System.out.print(num + " ");
                num1 = num2;
                num2 = num;
            }
        }
        System.out.println();

    }
}