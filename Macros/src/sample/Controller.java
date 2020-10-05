package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Macro macro = new Macro(400, 10);

    ObservableList<Coordinate> Coordinates = FXCollections.observableArrayList();

    @FXML private TextField X;
    @FXML private TextField Y;

    @FXML private Button addButton = new Button();


    private ObservableList<String> Clicks =
            FXCollections.observableArrayList(
                    "Left Click",
                    "Right Click",
                    "Special Click"
            );

    @FXML private ComboBox<String> comboBox;

    @FXML private TableView<Coordinate> tableView;

    @FXML private TableColumn<Coordinate, String> PColumn;
    @FXML private TableColumn<Coordinate, String> XColumn;
    @FXML private TableColumn<Coordinate, String> YColumn;
    @FXML private TableColumn<Coordinate, String> CColumn;


    @FXML
    private void addCoordinate() {
        macro.addCoordinate(Integer.parseInt(X.getText()), Integer.parseInt(Y.getText()), ClickType.parseClick(comboBox.getValue()));
        Coordinates.add(new Coordinate(Integer.parseInt(X.getText()), Integer.parseInt(Y.getText()), ClickType.parseClick(comboBox.getValue())));
        System.out.println(Coordinates.get(0).getCstring());
        tableView.refresh();

    }


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        XColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        XColumn.setOnEditCommit( event -> {
                    ((Coordinate) event.getTableView().getItems().get(
                            event.getTablePosition().getRow())
                    ).setX(Integer.parseInt(event.getNewValue()));
                    Coordinates.set(event.getTablePosition().getRow(), new Coordinate(Integer.parseInt(event.getNewValue()),
                            YColumn.getTableView().getItems().get(event.getTablePosition().getRow()).getY(),
                            CColumn.getTableView().getItems().get(event.getTablePosition().getRow()).getC()));
                }
        );

        YColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        YColumn.setOnEditCommit( event -> {
            ((Coordinate) event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
            ).setY(Integer.parseInt(event.getNewValue()));
            Coordinates.set(event.getTablePosition().getRow(), new Coordinate(
                    XColumn.getTableView().getItems().get(event.getTablePosition().getRow()).getX(), Integer.parseInt(event.getNewValue()),
                    CColumn.getTableView().getItems().get(event.getTablePosition().getRow()).getC()));
                }
        );

        CColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CColumn.setOnEditCommit(event -> {
                    try {
                        ((Coordinate) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setC(ClickType.parseClick(event.getNewValue()));
                        Coordinates.set(event.getTablePosition().getRow(), new Coordinate(
                                XColumn.getTableView().getItems().get(event.getTablePosition().getRow()).getX(), YColumn.getTableView().getItems().get(event.getTablePosition().getRow()).getY(),
                                ClickType.parseClick(event.getNewValue())));

                    } catch (Exception e) {
                        Coordinates.remove(event.getTablePosition().getRow());
                        tableView.refresh();
                    }

                });


        XColumn.setCellValueFactory(
                new PropertyValueFactory<Coordinate,String>("Xstring")
        );
        YColumn.setCellValueFactory(
                new PropertyValueFactory<Coordinate,String>("Ystring")
        );
        CColumn.setCellValueFactory(
                new PropertyValueFactory<Coordinate,String>("Cstring")
        );
        PColumn.setCellValueFactory(
                new PropertyValueFactory<Coordinate, String>("Pstring")
        );
        tableView.setEditable(true);
        tableView.setItems(Coordinates);
        comboBox.getItems().setAll(Clicks);

    }


}
