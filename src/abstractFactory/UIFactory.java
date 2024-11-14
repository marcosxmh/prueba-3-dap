package abstractFactory;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
    Dialog createDialog();
    NotificationCenter createNotificationCenter();
}
