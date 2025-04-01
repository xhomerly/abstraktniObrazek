module com.xhomerly.abstraktniobrazek {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.xhomerly.abstraktniobrazek to javafx.fxml;
    exports com.xhomerly.abstraktniobrazek;
}