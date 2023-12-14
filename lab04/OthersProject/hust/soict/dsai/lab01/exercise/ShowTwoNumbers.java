import javax.swing.JOptionPane;
// Nguyen Manh Hieu 20215050

public class ShowTwoNumbers {
        public static void main(String[] args) {
                String strNum1, strNum2;
                String strNotification = "Nguyen Manh Hieu - 5050-You've just entered: ";

                strNum1 = JOptionPane.showInputDialog(null, "Nguyen Manh Hieu - 5050-Please input the first number: ",
                                "Nguyen Manh Hieu - 5050 -Input the first number", JOptionPane.INFORMATION_MESSAGE);
                strNotification += strNum1 + " and ";

                strNum2 = JOptionPane.showInputDialog(null, "Nguyen Manh Hieu - 5050-Please input the second number: ",
                                " Nguyen Manh Hieu - 5050 - Input the second number", JOptionPane.INFORMATION_MESSAGE);
                strNotification += strNum2;
                JOptionPane.showMessageDialog(null, strNotification, "Nguyen Manh Hieu - 5050 Show two numbers",
                                JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
}