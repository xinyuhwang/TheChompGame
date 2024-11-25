module com.project.thechompgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.project.thechompgame to javafx.fxml;
    exports com.project.thechompgame;
}