module letisiaornelle.com.fillthedish1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens letisiaornelle.com.fillthedish1 to javafx.fxml;
    exports letisiaornelle.com.fillthedish1;
}