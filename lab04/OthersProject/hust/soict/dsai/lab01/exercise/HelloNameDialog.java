import javax.swing.JOptionPane;
// Nguyen Manh Hieu 20215050

public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Nguyen Manh Hieu 5050 - Please enter your name");
        JOptionPane.showMessageDialog(null, "Toi la Nguyen Manh Hieu 5050. Hi " + result + "!");
        System.exit(0);
    }
}