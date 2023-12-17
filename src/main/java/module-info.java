module com.example.pusearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires rest.assured;
    requires json.path;
    requires AnimateFX;


    opens com.example.pusearch to javafx.fxml;
    exports com.example.pusearch;
}