// src/products/linux/GtkLibrary.java
package concreteFactories.linux;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface GtkLibrary extends Library {
    GtkLibrary INSTANCE = Native.load("gtk-3", GtkLibrary.class);

    void gtk_init(int argc, String[] argv);
    long gtk_window_new(int type);
    void gtk_window_set_title(long window, String title);
    void gtk_window_set_default_size(long window, int width, int height);
    void gtk_widget_show_all(long widget);
    void gtk_main();
    void gtk_main_quit();
}
