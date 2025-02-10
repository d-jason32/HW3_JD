module org.example.hw3_jd {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.hw3_jd to javafx.fxml;
    exports org.example.hw3_jd;
}