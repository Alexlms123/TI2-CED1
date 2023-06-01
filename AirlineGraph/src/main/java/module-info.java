module com.example.airlinegraph {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.airlinegraph to javafx.fxml;
    exports com.example.airlinegraph;
    exports com.example.airlinegraph.graph;
    opens com.example.airlinegraph.graph to javafx.fxml;
    exports com.example.airlinegraph.ui;
    opens com.example.airlinegraph.ui to javafx.fxml;
}