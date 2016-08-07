package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * Created by Gabirel on 8/7/16.
 */
public class PersonOverViewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    //Reference to the main application
    private MainApp mainApp;

    /*
    * The constructor
    * The constructor is called before the inialize() method
    */
    public PersonOverViewController(){

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded
     */
    @FXML
    private void initialize(){
        //Initialize the person table with two columns
        firstNameColumn.setCellValueFactory(cellData->cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData->cellData.getValue().lastNameProperty());
    }

    public void setMainApp(MainApp mainApp){
        personTable.setItems(mainApp.getPersonData());
    }

}
