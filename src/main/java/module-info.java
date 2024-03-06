module com.cold.coldlauncher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.cold.coldlauncher to javafx.fxml;
    exports com.cold.coldlauncher;
}