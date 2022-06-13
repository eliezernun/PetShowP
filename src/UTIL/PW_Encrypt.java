package UTIL;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
public class PW_Encrypt {
    public  String PW_Encrypt(String pw){
        Encoder encoder = Base64.getEncoder();
        String originalString = pw;
        String encodedString = encoder.encodeToString(originalString.getBytes());
        System.out.println(encodedString);
        return encodedString;
    }

    public String PW_Decrypt(String pw){
        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(pw);
        return new String(bytes);
    }
}
