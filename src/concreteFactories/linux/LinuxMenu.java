package concreteFactories.linux;

import abstractFactory.Menu;
import javax.swing.*;
import java.awt.*;

public class LinuxMenu implements Menu {

    @Override
    public void render() {
        JFrame frame = new JFrame("Linux Style Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        JMenuItem menuItem3 = new JMenuItem("Exit");

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.addSeparator();
        menu.add(menuItem3);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
