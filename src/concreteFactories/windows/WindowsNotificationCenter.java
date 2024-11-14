package concreteFactories.windows;

import abstractFactory.NotificationCenter;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.W32APIOptions;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

public class WindowsNotificationCenter implements NotificationCenter {

    // Definimos el valor de MB_ICONINFORMATION manualmente
    private static final int MB_ICONINFORMATION = 0x40;

    // Interfaz para cargar la biblioteca User32 de Windows mediante JNA
    public interface User32 extends Library {
        User32 INSTANCE = Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

        // Función para mostrar un mensaje (MessageBox)
        int MessageBox(Pointer hWnd, String lpText, String lpCaption, int uType);
    }

    @Override
    public void showNotification(String title, String message) {
        // Utilizamos la función MessageBox de User32 para mostrar la notificación en Windows
        User32.INSTANCE.MessageBox(null, message, title, MB_ICONINFORMATION);
        System.out.println("Notification displayed (Windows-specific): " + title + " - " + message);
    }

    public void showSystemInfoNotification() {
        // Obtiene información del sistema (con OSHI) y la muestra en una notificación
        String systemInfoMessage = getSystemInfo();
        showNotification("System Information", systemInfoMessage);
    }

    private String getSystemInfo() {
        // Metodo auxiliar para obtener la información del sistema con OSHI
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem os = systemInfo.getOperatingSystem();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        return String.format("OS: %s\nCPU: %s\nMemory: %.2f GB",
                os, processor, memory.getTotal() / (1024.0 * 1024 * 1024));
    }
}
