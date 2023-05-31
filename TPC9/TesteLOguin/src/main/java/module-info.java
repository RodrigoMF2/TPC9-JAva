module com.example.testeloguin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.testeloguin to javafx.fxml;
    exports com.example.testeloguin;
}