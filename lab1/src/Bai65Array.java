import java.util.Scanner;
import java.util.Arrays;
public class Bai65Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = keyboard.nextInt();
        System.out.println("Enter " + n + " numbers: ");
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = keyboard.nextDouble();
        }
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + sum/n);
    }
}
