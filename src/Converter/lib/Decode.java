package Converter.lib;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * Created by Gabirel on 8/18/16.
 * 1. Base64 Decode
 * 2. URL Decoder
 */
public class Decode {
    public String reverseBase64(String cipherText) {
        String plainText;

        Base64.Decoder decoder = Base64.getDecoder();

        plainText = new String(decoder.decode(cipherText));
        return plainText;
    }


    public String reverseBase64URLEncode(String urlEncodedText) {
        String plainText;

        Base64.Decoder decoder = Base64.getUrlDecoder();

        plainText = new String(decoder.decode(urlEncodedText));
        return plainText;
    }


    public String reverseURLEncode(String urlEncodedText) {
        String plainText;

        try {
            plainText = URLDecoder.decode(urlEncodedText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return plainText;
    }
}
