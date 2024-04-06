module com.example.clothing_assistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens com.example.clothing_assistant to javafx.fxml;
    exports com.example.clothing_assistant;
}