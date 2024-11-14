package concreteFactories.windows;

import abstractFactory.*;

public class WindowsFactory implements UIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Menu createMenu() {
        return new WindowsMenu();
    }
    public Dialog createDialog() {
        return new WindowsDialog();
    }
    public NotificationCenter createNotificationCenter() {
        return new WindowsNotificationCenter();
    }
}
