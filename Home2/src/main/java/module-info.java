module home.home2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens home.home2 to javafx.fxml;
    exports home.home2;

}