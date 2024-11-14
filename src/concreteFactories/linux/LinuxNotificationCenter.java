package concreteFactories.linux;

import abstractFactory.NotificationCenter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinuxNotificationCenter implements NotificationCenter {

    @Override
    public void showNotification(String title, String message) {
        try {
            // Ejecutar el comando `notify-send` para mostrar la notificación
            String[] command = {"notify-send", title, message};
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSystemInfoNotification() {
        String systemInfo = getSystemInfo();
        showNotification("System Information", systemInfo);
    }

    private String getSystemInfo() {
        try {
            Process process = Runtime.getRuntime().exec("uname -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unable to retrieve system information.";
        }
    }
}
