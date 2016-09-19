package Converter.lib;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Gabirel on 8/16/16.
 *
 * @author Gabirel   (https://github.com/Gabirel)
 */
public class EncodeOneway {

    /**
     * You give string to 'getMD5', then you'll get your md5 hash
     * bits:    '16' ==> generate 16bits hash
     *          '32' ==> generate 32bits hash
     * LetterCase:  'true' ==> 'Uppercase'
     *              'false' ==> 'Lowercase'
     */
    public String getMD5(int bits, String plainText, Boolean LetterCase) {
        String cipherText;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(plainText.getBytes());
            cipherText = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

        if (bits == 32 && LetterCase == false) {
            return cipherText;
        } else if (bits == 32 && LetterCase == true) {
            return cipherText.toUpperCase();
        } else if (bits == 16 && LetterCase == false) {
            return cipherText.substring(8, 24);
        } else if (bits == 16 && LetterCase == true) {
            return cipherText.substring(8, 24).toUpperCase();
        } else {
            System.out.println("Failure: MD5 is not generated!\nParameters are not right!! Check It");
        }
        //Actually it is not necessary, but it can't be compiled successfully without this 'return'.
        return cipherText;
    }


    /**
     * algorithmOption:  '0' ==> 'SHA-1'
     *                   '1' ==> 'SHA-224'
     *                   '2' ==> 'SHA-256'
     *                   '3' ==> 'SHA-384'
     *                   '4' ==> 'SHA-512'
     *
     * LetterCase:  'false' ==> 'LowerCase'
     *              'true' ==> 'UpperCase'
     */
    public String getSHA(int algorithmOption, String plainText, Boolean LetterCase){
        String cipherText;
        String[] algorithm = {"SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512"};

        if (algorithmOption < 0 || algorithmOption > 4){
            System.out.println("algorithmOption value should be '0-4'");
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm[algorithmOption]);
            messageDigest.update(plainText.getBytes());
            cipherText = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

        if (LetterCase){
            return cipherText.toUpperCase();
        }
        return cipherText;
    }
}
