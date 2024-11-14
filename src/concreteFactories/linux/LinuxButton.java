package concreteFactories.linux;

import abstractFactory.Button;
import javax.swing.*;
import java.awt.*;

public class LinuxButton implements Button {

    @Override
    public void render() {
        JFrame frame = new JFrame("Linux Style Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Linux Button");
        button.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        button.setBackground(Color.LIGHT_GRAY);
        button.setFocusPainted(false);

        frame.getContentPane().add(button);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
