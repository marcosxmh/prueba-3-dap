import abstractFactory.*;
import concreteFactories.linux.LinuxFactory;
import concreteFactories.windows.WindowsFactory;

public class App {
    public static void main(String[] args) {
        // Detectar el sistema operativo
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Detected OS: " + osName);

        UIFactory factory;

        // Detectar si estamos en Windows o Linux y usar la factoría correspondiente
        if (osName.contains("win")) {
            factory = new WindowsFactory();
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("linux")) {
            factory = new LinuxFactory();
        } else {
            System.out.println("Unsupported operating system.");
            return;
        }

        // Crear una instancia del menú para el sistema operativo detectado
        Menu menu = factory.createMenu();

        // Renderizar la ventana del menú
        menu.render();
    }
}
