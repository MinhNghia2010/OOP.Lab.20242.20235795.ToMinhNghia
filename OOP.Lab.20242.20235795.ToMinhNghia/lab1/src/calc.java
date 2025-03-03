import javax.swing.JOptionPane;
public class calc {
    public static void main(String[] args) {
        String strNum1, strNum2, strOperation;
        double doubleNum1, doubleNum2, doubleResult;
        strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        doubleNum1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        doubleNum2 = Double.parseDouble(strNum2);
        strOperation = JOptionPane.showInputDialog(null, "Please enter the operation: ","Input the operation", JOptionPane.INFORMATION_MESSAGE);
        if (strOperation.equals("+")) {
            doubleResult = doubleNum1 + doubleNum2;
            JOptionPane.showMessageDialog(null, doubleResult, strNum1 + " + " + strNum2, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (strOperation.equals("-")) {
            doubleResult = doubleNum1 - doubleNum2;
            JOptionPane.showMessageDialog(null, doubleResult, strNum1 + " - " + strNum2, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (strOperation.equals("*")) {
            doubleResult = doubleNum1 * doubleNum2;
            JOptionPane.showMessageDialog(null, doubleResult, strNum1 + " * " + strNum2, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (strOperation.equals("/")) {
            if (doubleNum2 == 0) {
                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            doubleResult = doubleNum1 / doubleNum2;
            JOptionPane.showMessageDialog(null, doubleResult, strNum1 + " / " + strNum2, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
