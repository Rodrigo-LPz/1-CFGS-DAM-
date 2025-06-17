import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalindromeChecker extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField textField;
    private JButton button;

    public PalindromeChecker() {
        super("Comprobador de Palíndromos");

        label = new JLabel("Introduce un texto o número:");
        textField = new JTextField(20);
        button = new JButton("Comprobar");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        if (isPalindrome(text)) {
            JOptionPane.showMessageDialog(this, text + " es un palíndromo.");
        } else {
            JOptionPane.showMessageDialog(this, text + " no es un palíndromo.");
        }
    }

    private boolean isPalindrome(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedText = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversedText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PalindromeChecker());
    }
}
