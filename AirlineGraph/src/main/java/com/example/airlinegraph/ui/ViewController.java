package com.example.airlinegraph.ui;

import com.example.airlinegraph.graph.Edge;
import com.example.airlinegraph.model.AirlineUSA;
import com.example.airlinegraph.model.USAState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    private AirlineUSA controller;

    private ObservableList<USAState> list;

    @FXML
    private TableView<USAState> tableFrom;
    @FXML
    private TableView<USAState> tableTo;
    @FXML
    private TableColumn<USAState, String> tableColFrom;
    @FXML
    private TableColumn<USAState, String> tableColTo;

    @FXML
    private TextField searchBarFrom;

    @FXML
    private TextField searchBarTo;

    @FXML
    private ListView<String> route;

    @FXML
    private TextField travelTime;


    public ViewController() {

        list = FXCollections.observableArrayList();
        controller = new AirlineUSA();
        route = new ListView<>();

        list.addAll(controller.getStates().values());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setUpTable(tableFrom, tableColFrom, searchBarFrom);
        setUpTable(tableTo, tableColTo, searchBarTo);


    }

    public void setTableEvents(TableView<USAState> table, TextField searchBar) {
        table.setOnMouseClicked((event) -> {
            USAState selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null)
                searchBar.setText(selectedItem.getUSAState());
        });

    }

    public void setUpTable(TableView<USAState> table, TableColumn<USAState, String> col, TextField searchBar) {

        col.setCellValueFactory(new PropertyValueFactory<>("name"));

        FilteredList<USAState> filteredData = new FilteredList<>(list, p -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(station -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (station.getUSAState().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });
        });


        SortedList<USAState> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setTableEvents(table, searchBar);

    }

    public void findFastestRoute() {

        String from = searchBarFrom.getText();
        String to = searchBarTo.getText();

        if (to.isEmpty() || from.isEmpty()) return;

        Edge<USAState> edge = controller.findFastestRoute(from, to);

        ObservableList<String> routeList = FXCollections.observableArrayList();

        edge.getEdge().forEach(state -> routeList.add(state.getUSAState()));

        route.setItems(routeList);

        travelTime.setText(edge.getDistance() + " min");

    }

    public void findShortestRoute() {

        String from = searchBarFrom.getText();
        String to = searchBarTo.getText();

        if (to.isEmpty() || from.isEmpty()) return;

        Edge<USAState> path = controller.findShortestRoute(from, to);

        ObservableList<String> routeList = FXCollections.observableArrayList();

        path.getEdge().forEach(station -> routeList.add(station.getUSAState()));

        route.setItems(routeList);

        travelTime.setText(((int) path.getDistance()) + " states");

    }
}