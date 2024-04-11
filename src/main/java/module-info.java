module com.example.clothing_assistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens com.example.clothing_assistant_view to javafx.fxml;
    exports com.example.clothing_assistant_view;
    exports com.example.clothing_assistant_data;
    opens com.example.clothing_assistant_data to javafx.fxml;
}