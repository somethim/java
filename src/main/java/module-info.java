module classwork.classwork {
    requires javafx.controls;
    requires javafx.fxml;


    opens classwork.classwork to javafx.fxml;
    exports classwork.classwork;
}