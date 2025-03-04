package Bai226;
import javax.swing.JOptionPane;
public class FDLtwoVariables {
    public static void main(String[] args) {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2: "));
        double det = a11 * a22 - a12 * a21;
        double det1 = b1 * a22 - b2 * a12;
        double det2 = a11 * b2 - a21 * b1;
        if(det == 0){
            if(a11 / a21 == a12 / a22 && b1 / b2 == a11 / a21){
                JOptionPane.showMessageDialog(null, "Infinite solutions");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "x1 = " + (det1 / det) + "\nx2 = " + (det2 / det));
            System.exit(0);
        }
    }
}
