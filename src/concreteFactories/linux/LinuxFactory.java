package concreteFactories.linux;

import abstractFactory.*;

public class LinuxFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }

    @Override
    public Dialog createDialog() {
        return new LinuxDialog();
    }

    @Override
    public NotificationCenter createNotificationCenter() {
        return new LinuxNotificationCenter();
    }
}
