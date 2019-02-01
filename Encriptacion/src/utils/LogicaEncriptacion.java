package utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author adolfolaviana
 */
public class LogicaEncriptacion {
    
    public static String encriptar(String textoEncriptar){
    
        String clave = "PaquitoElChocolatero"; //llave para encriptar datos
        String base64claveEncriptada = "";
 
        try {
 
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] contraseñaDigest = messageDigest.digest(clave.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(contraseñaDigest, 24);
 
            SecretKey claveSecreta = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, claveSecreta);
 
            byte[] textoBytes = textoEncriptar.getBytes("utf-8");
            byte[] buf = cipher.doFinal(textoBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64claveEncriptada = new String(base64Bytes);
 
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        }
        return base64claveEncriptada;
    }
    
     public static String desencriptar(String textoEncriptado) throws Exception {
 
        String secretKey = "PaquitoElChocolatero"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] mensaje = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher descifrar = Cipher.getInstance("DESede");
            descifrar.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = descifrar.doFinal(mensaje);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        }
        return base64EncryptedString;
    }
}
