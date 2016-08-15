package Converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class Controller {
    @FXML           //fx:id="orignalTextArea"
    private TextArea orignalTextArea;
    @FXML           //fx:id="encodedTextArea"
    private TextArea encodedTextArea;

    @FXML
    private Button encodeButton;
    @FXML
    private Button decodeButton;


    //When "Encode" Button Clicked
    @FXML
    public void onencodeButtonClicked(ActionEvent actionEvent){
        encodedTextArea.setText(orignalTextArea.getText());
    }

    //When "Decode" Button Clicked
    @FXML
    public void ondecodeButtonClicked(ActionEvent actionEvent){
        orignalTextArea.setText(encodedTextArea.getText());
    }

}
