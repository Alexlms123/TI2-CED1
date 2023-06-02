module com.example.airlinegraph {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.datatransfer;

    opens com.example.airlinegraph to javafx.fxml;
    exports com.example.airlinegraph;
    exports com.example.airlinegraph.graph;
    opens com.example.airlinegraph.graph to javafx.fxml;
    exports com.example.airlinegraph.ui;
    opens com.example.airlinegraph.ui to javafx.fxml;
}