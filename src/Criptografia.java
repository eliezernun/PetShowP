
import java.io.UnsupportedEncodingException;
import java.security.*;

public class Criptografia {
    String senha;

    /**
     * 
     * @param args Recebe a senha no formato String;
     */
    private Criptografia(String args){
       this.senha = args;
    }

    /**
     * 
     * @return Senha criptografada formato byte
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public byte[]  setCriptografia() throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
        System.out.println(messageDigest);
        return messageDigest;
    }   
}
