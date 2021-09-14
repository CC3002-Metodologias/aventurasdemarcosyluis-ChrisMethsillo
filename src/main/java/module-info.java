module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.aventurasdemarcoyluis.model.npc;
    opens com.example.aventurasdemarcoyluis.model.npc to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.playablechar;
    opens com.example.aventurasdemarcoyluis.model.playablechar to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.items;
    opens com.example.aventurasdemarcoyluis.model.items to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model;
    opens com.example.aventurasdemarcoyluis.model to javafx.fxml;
}