package concreteFactories.windows;

import abstractFactory.Button;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class WindowsButton implements Button {

    @Override
    public void render() {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the main window
        JFrame frame = new JFrame("Windows Style Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create the button with the text "Windows Button"
        JButton button = new JButton("Windows Button");

        // Additional customization to make it look like a Windows button
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Windows font
        button.setForeground(Color.BLACK);
        button.setBackground(UIManager.getColor("Button.background")); // Default background color
        button.setFocusPainted(false); // Disable focus border
        button.setBorder(UIManager.getBorder("Button.border")); // Default border
        button.setMargin(new Insets(5, 15, 5, 15)); // Margins for better appearance

        // Add the button to the window
        frame.getContentPane().add(button);

        // Make the window visible and centered
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}