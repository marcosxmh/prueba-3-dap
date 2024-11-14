package concreteFactories.windows;

import abstractFactory.Dialog;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class WindowsDialog implements Dialog {

    public WindowsDialog() {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Customize dialog appearance
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("OptionPane.background", UIManager.getColor("Panel.background"));
        UIManager.put("Panel.background", UIManager.getColor("Panel.background"));
    }

    @Override
    public void render() {
        showMessageDialog("This is a Windows style dialog", "Windows Dialog", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessageDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    public void showConfirmDialog(String message, String title) {
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.out.println("User selected Yes");
        } else {
            System.out.println("User selected No");
        }
    }

    public void showInputDialog(String message, String title) {
        String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        System.out.println("User input: " + input);
    }
}