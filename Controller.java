package Converter;

import Converter.lib.Decode;
import Converter.lib.EncodeOneway;
import Converter.lib.EncodeReversible;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller {
    //Menu Component is here
    //Maybe It is unnecessary to do like this
    //But I want it. What else could you say??
    @FXML
    private MenuItem closeMenu;
    @FXML
    private MenuItem clearMenu;
    @FXML
    private MenuItem aboutMenu;


    //Main Component is here
    @FXML           //fx:id="originalTextArea"
    private TextArea originalTextArea;
    @FXML           //fx:id="encodedTextArea"
    private TextArea encodedTextArea;

    @FXML
    private Button originalTextAreaUpperButton;
    @FXML
    private Button originalTextAreaLowerButton;
    @FXML
    private Button encodedTextAreaButton;

    @FXML
    private ChoiceBox<String> encodeChoiceBox;
    @FXML
    private ChoiceBox<String> decodeChoiceBox;



    //`File` Menu Components' actions are here
    @FXML
    private void closeMenuOnClicked(){
    }

    //`Edit` Menu Components' actions are here
    @FXML
    private void clearMenuOnClicked(){
        originalTextArea.setText("");
        encodedTextArea.setText("");
    }

    //`Help` Menu Componets' actions are here
    @FXML
    private void aboutMenuOnClicked(){

    }



    //Main component's buttons are here
    @FXML
    private void EncodeAgainButtonOnClicked(){
        String resultText;

        resultText = setEncodeSwitch(encodeChoiceBox.getSelectionModel().getSelectedIndex());
        encodedTextArea.setText(resultText);
    }

    @FXML
    private void DecodeAgainButtonOnClicked(){
        String resultText;

        resultText = setDecodeSwith(decodeChoiceBox.getSelectionModel().getSelectedIndex());
        originalTextArea.setText(resultText);
    }


    //Make Button into `Enabled Uppercase`
    public void setButton2EnableUppercase(Button button){
        button.setDisable(false);
        button.setText("UpperCase");
    }




    //Switch case in ChoiceBox for `Encode Again` Button and `Decode Again` Button
    //Those will be called twice. That's why I isolate them.
    //
    //0 ==> -- Encode Reversible
    //1 ==> Base64 Encode
    //2 ==> URL(Base64-Style) Encode
    //3 ==> URL Encode
    //4 ==> -- Encode One-way
    //5 ==> MD5(32) Encode
    //6 ==> MD5(16) Encode
    //7 ==> SHA-1 Encode
    //8 ==> SHA-224 Encode
    //9 ==> SHA-256 Encode
    //10 ==> SHA-384 Encode
    //11 ==> SHA-512 Encode
    public String setEncodeSwitch(int indexofChoice){
        EncodeReversible encodeReversible = new EncodeReversible();
        EncodeOneway encodeOneway = new EncodeOneway();
        String resultText = "";

        switch (indexofChoice){
            case 0:
                encodedTextArea.setPromptText("Please select method you want to encode.");
                break;
            case 1:
                resultText = encodeReversible.getBase64(originalTextArea.getText());
                break;
            case 2:
                resultText = encodeReversible.getBase64URLEncoded(originalTextArea.getText());
                break;
            case 3:
                resultText = encodeReversible.getURLEncoded(originalTextArea.getText());
                break;
            case 4:
                encodedTextArea.setPromptText("Please select method you want to encode.");
                break;
            case 5:
                resultText = encodeOneway.getMD5(32, originalTextArea.getText(), false);
                break;
            case 6:
                resultText = encodeOneway.getMD5(16, originalTextArea.getText(), false);
                break;
            case 7:
                resultText = encodeOneway.getSHA(0, originalTextArea.getText(), false);
                break;
            case 8:
                resultText = encodeOneway.getSHA(1, originalTextArea.getText(), false);
                break;
            case 9:
                resultText = encodeOneway.getSHA(2, originalTextArea.getText(), false);
                break;
            case 10:
                resultText = encodeOneway.getSHA(3, originalTextArea.getText(), false);
                break;
            case 11:
                resultText = encodeOneway.getSHA(4, originalTextArea.getText(), false);
                break;
            default:
                resultText = "Unexpected Error!";
        }

        return  resultText;
    }



    //0 ==> -- Decode --
    //1 ==> Base64 Decode
    //2 ==> URL(Base64-Style) Decode
    //3 ==> URL Decode
    public String setDecodeSwith(int indexOfChoice){
        Decode decode = new Decode();
        String resultText = "";

        switch (indexOfChoice){
            case 0:
                originalTextArea.setPromptText("Please select method you want to encode.");
                break;
            case 1:
                resultText = decode.reverseBase64(encodedTextArea.getText());
                break;
            case 2:
                resultText = decode.reverseBase64URLEncode(encodedTextArea.getText());
                break;
            case 3:
                resultText = decode.reverseURLEncode(encodedTextArea.getText());
                break;
            default:
                resultText = "Unexpected Error!";

        }

        return resultText;
    }




    @FXML
    public void initialize() {


        //OriginalTextAreaButtons Event
        originalTextAreaUpperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                originalTextArea.setText(originalTextArea.getText().toUpperCase());
            }
        });
        originalTextAreaLowerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                originalTextArea.setText(originalTextArea.getText().toLowerCase());
            }
        });


        //EncodedTextAreaButton Event
        encodedTextAreaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (encodedTextAreaButton.getText().equals("UpperCase")){
                    encodedTextArea.setText(encodedTextArea.getText().toUpperCase());
                    encodedTextAreaButton.setText("LowerCase");
                }else if (encodedTextAreaButton.getText().equals("LowerCase")){
                    encodedTextArea.setText(encodedTextArea.getText().toLowerCase());
                    encodedTextAreaButton.setText("UpperCase");
                }else{
                    System.out.println("Unexpected Error!!");
                }
            }
        });

        //Encoding Function
        encodeChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String resultText;

                resultText = setEncodeSwitch(encodeChoiceBox.getSelectionModel().getSelectedIndex());
                encodedTextArea.setText(resultText);

                //Enable Uppercase Button when MD5 and SHA* are selected
                switch (encodeChoiceBox.getSelectionModel().getSelectedIndex()){
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        setButton2EnableUppercase(encodedTextAreaButton);
                        break;
                    default:
                        System.out.println("This method doesn't support this");
                }
            }
        });


        //Decoding Function
        decodeChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String resultText;

                resultText = setDecodeSwith(decodeChoiceBox.getSelectionModel().getSelectedIndex());
                originalTextArea.setText(resultText);
            }
        });
    }

}
