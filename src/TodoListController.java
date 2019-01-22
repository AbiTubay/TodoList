import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author abigail
 */
public class TodoListController implements Initializable {
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        date.setValue(LocalDate.now()); //set date to now
    }
    
    //FXML components
    @FXML
    Button addButton;
    @FXML
    TextField textField;
    @FXML
    DatePicker date;
    @FXML
    ListView<LocalEvent> eventList;
    @FXML
    Button deleteButton;

    //sort events into an observable list
    ObservableList<LocalEvent> list = FXCollections.observableArrayList();
    
    /**
     * 
     * @param e addButton listener
     */
    @FXML
    private void addEvent(Event e){
        if(textField.getText() == null || textField.getText().trim().isEmpty()){
            try{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Failure to Add");
                alert.setContentText("You have not typed anything");
                alert.showAndWait();
                refresh();
            }catch(NullPointerException err){
                err.printStackTrace();
            }
        }else{
            list.add(new LocalEvent(textField.getText()));
            eventList.setItems(list);
            refresh();
        }
    }
    
    /**
     * delete events that are finished
     * automatically refreshes list view
     * @param e deleteButton listener
     */
    @FXML
    private void deleteEvent(Event e){
        int index = eventList.getSelectionModel().getSelectedIndex();
        list.remove(index);
    }
    
    /**
     * tidy interface after button events
     * so that the text field is cleared and is ready for the next event
     */
    private void refresh(){
        textField.setText(null);
    }
    
}
