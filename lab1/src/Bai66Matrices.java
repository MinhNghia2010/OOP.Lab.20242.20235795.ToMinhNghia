import java.util.Scanner;
public class Bai66Matrices {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the matrix:");
        int n = keyboard.nextInt();
        int m = keyboard.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("The sum of the matrices is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + b[i][j] + " ");
            }
            System.out.println();
        }
        keyboard.close();
    }
}
