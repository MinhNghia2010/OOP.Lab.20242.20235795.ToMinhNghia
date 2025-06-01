module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}