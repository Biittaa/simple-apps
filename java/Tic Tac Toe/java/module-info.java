module com.example.demo31 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo31 to javafx.fxml;
    exports com.example.demo31;
}