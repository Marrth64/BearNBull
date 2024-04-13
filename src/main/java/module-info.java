module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.moshi;
    requires com.squareup.moshi;
    requires kotlin.stdlib;

    opens com.example.project to javafx.fxml;
    exports com.example.project;
}