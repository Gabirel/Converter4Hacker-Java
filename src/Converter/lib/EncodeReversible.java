package Converter.lib;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * Created by Gabirel on 8/18/16.
 * 1. Base64
 * 2. Base64 img
 * 3. URL
 * 4. FULL URL Encode??(Not sure)
 * Reference: https://magiclen.org/java-base64/
 */
public class EncodeReversible {

    //This stupid function will give you Base64(Encoding)
    public String getBase64(String plainText){
        String cipherText;

        Base64.Encoder encoder = Base64.getEncoder();

        cipherText = encoder.encodeToString(plainText.getBytes());
        return cipherText;
    }


    //This stupid function will give you Base64-style URL-encoded String/Text
    public String getBase64URLEncoded(String plainText){
        String urlEncodedText;

        Base64.Encoder encoder = Base64.getUrlEncoder();
        urlEncodedText = encoder.encodeToString(plainText.getBytes());

        return urlEncodedText;
    }


    //This stupid function will give you URL-encoded Text/String
    public String getURLEncoded(String plainText){
        String urlEncodedText;

        try {
            urlEncodedText = URLEncoder.encode(plainText, "UTF-8");
        }catch (UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }

        return urlEncodedText;
    }
}
