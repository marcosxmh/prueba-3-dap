package concreteFactories.linux;

import abstractFactory.Dialog;
import javax.swing.*;

public class LinuxDialog implements Dialog {

    @Override
    public void render() {
        showMessageDialog("This is a Linux style dialog", "Linux Dialog");
    }

    public void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showConfirmDialog(String message, String title) {
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.out.println("User selected Yes");
        } else {
            System.out.println("User selected No");
        }
    }
}
