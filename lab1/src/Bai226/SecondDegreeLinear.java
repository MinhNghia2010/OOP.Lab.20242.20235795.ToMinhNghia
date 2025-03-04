package Bai226;
import javax.swing.JOptionPane;
public class SecondDegreeLinear {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c: "));
        double discriminant = b * b - 4 * a * c;
        if(a == 0){
            if(b == 0){
                if (c == 0){
                    JOptionPane.showMessageDialog(null, "Infinite solutions");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "No solution");
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "x = " + (-c / b));
                System.exit(0);
            }
        } else {
            if (discriminant < 0) {
                JOptionPane.showMessageDialog(null, "No solution");
                System.exit(0);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "x = " + x);
                System.exit(0);
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
                System.exit(0);
            }
        }
    }
}
