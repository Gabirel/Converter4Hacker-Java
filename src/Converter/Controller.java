package Converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class Controller {
    @FXML
    private TextArea orignalTextArea;
    @FXML
    private TextArea encodedTextArea;

    @FXML
    private Button encodeButton;
    @FXML
    private Button decodeButton;


    //When "Encode" Button Clicked
    @FXML
    public void onencodeButtonClicked(ActionEvent actionEvent){
        encodedTextArea.setText("I'm Enocded: " + orignalTextArea.getText());
    }

    //When "Decode" Button Clicked
    @FXML
    public void ondecodeButtonClicked(ActionEvent actionEvent){
        orignalTextArea.setText("I'm Decoded: " + encodedTextArea.getText());
    }

}
