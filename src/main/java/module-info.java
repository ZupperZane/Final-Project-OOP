module com.example.sim {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.sim to javafx.fxml;
    exports com.example.sim;
}