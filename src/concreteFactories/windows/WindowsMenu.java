package concreteFactories.windows;

import abstractFactory.Menu;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class WindowsMenu implements Menu {

    public WindowsMenu() {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Customize menu appearance
        UIManager.put("Menu.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("MenuItem.font", new Font("Segoe UI", Font.PLAIN, 14));
    }

    @Override
    public void render() {
        // Create the main window
        JFrame frame = new JFrame("Windows Style Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu menu = new JMenu("File");

        // Create menu items
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        JMenuItem menuItem3 = new JMenuItem("Exit");

        // Add menu items to the menu
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.addSeparator();
        menu.add(menuItem3);

        // Add the menu to the menu bar
        menuBar.add(menu);

        // Create buttons
        JButton button1 = new JButton("Create Windows Button");
        JButton button2 = new JButton("Create Windows Dialog");
        JButton button3 = new JButton("Show Notification");
        JButton button4 = new JButton("Show System Info");
        JButton button5 = new JButton("Show User Notification");

        // Add action listeners to buttons
        button1.addActionListener(e -> {
            WindowsButton windowsButton = new WindowsButton();
            windowsButton.render();
        });

        button2.addActionListener(e -> {
            WindowsDialog windowsDialog = new WindowsDialog();
            windowsDialog.render();
        });

        button3.addActionListener(e -> {
            WindowsNotificationCenter notificationCenter = new WindowsNotificationCenter();
            notificationCenter.showNotification("Notification Title", "This is a Windows notification.");
        });

        button4.addActionListener(e -> {
            WindowsNotificationCenter notificationCenter = new WindowsNotificationCenter();
            notificationCenter.showSystemInfoNotification();
        });

        button5.addActionListener(e -> {
            WindowsNotificationCenter notificationCenter = new WindowsNotificationCenter();
            notificationCenter.showNotification("User Notification", "This is a user notification.");
        });

        // Add buttons to the frame
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(button4);
        panel.add(button5);
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        bottomPanel.add(button3);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Make the window visible and centered
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}