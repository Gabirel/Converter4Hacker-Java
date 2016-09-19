package Converter;

import Converter.lib.Decode;
import Converter.lib.EncodeOneway;
import Converter.lib.EncodeReversible;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML           //fx:id="originalTextArea"
    private TextArea originalTextArea;
    @FXML           //fx:id="encodedTextArea"
    private TextArea encodedTextArea;


    @FXML
    private ChoiceBox<String> encodeChoiceBox;
    @FXML
    private ChoiceBox<String> decodeChoiceBox;


    @FXML
    public void initialize() {

        //Encoding Function
        encodeChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                EncodeReversible encodeReversible = new EncodeReversible();
                EncodeOneway encodeOneway = new EncodeOneway();
                String resultText;

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
                switch (encodeChoiceBox.getSelectionModel().getSelectedIndex()) {
                    case 0:
                        resultText = "Please select method you want to encode.";
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
                        resultText = "Please select method you want to encode.";
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
                encodedTextArea.setText(resultText);
            }
        });


        //Decoding Function
        decodeChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Decode decode = new Decode();
                String resultText;

                //0 ==> -- Decode --
                //1 ==> Base64 Decode
                //2 ==> URL(Base64-Style) Decode
                //3 ==> URL Decode
                switch (decodeChoiceBox.getSelectionModel().getSelectedIndex()){
                    case 0:
                        resultText = "Please select method you want to encode.";
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

                originalTextArea.setText(resultText);
            }
        });
    }
}
