package PruebasObjetos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    static Persona p = new Persona();
    

    public static String encriptar() {

        String fantasia = "PaquitoElChocolatero"; //llave para encriptar datos
        String base64claveEncriptada = "";

        try {
            p.setEdad(20);
            p.setNombre("adolfo");

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] contraseñaDigest = messageDigest.digest(fantasia.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(contraseñaDigest, 24);

            SecretKey claveSecreta = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, claveSecreta);

            ByteArrayOutputStream os = null;
            ObjectOutputStream oos = null;

            os = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(p);

            byte[] textoBytes = os.toByteArray();
            byte[] buf = cipher.doFinal(textoBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64claveEncriptada = new String(base64Bytes);

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        } catch (IOException ex) {
            Logger.getLogger(LogicaEncriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return base64claveEncriptada;
    }

    public static String desencriptar(String textoEncriptado) throws Exception {

        String fantasia = "PaquitoElChocolatero"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {
            byte[] mensaje = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestPassword = md.digest(fantasia.getBytes("utf-8"));
            byte[] claveBytes = Arrays.copyOf(digestPassword, 24);
            SecretKey claveSecreta = new SecretKeySpec(claveBytes, "DESede");

            Cipher descifrar = Cipher.getInstance("DESede");
            descifrar.init(Cipher.DECRYPT_MODE, claveSecreta);
            
            byte[] plainText = descifrar.doFinal(mensaje);
            
            ByteArrayInputStream is = null;
            ObjectInputStream ois = null;
            
            is = new ByteArrayInputStream(plainText);
            ois = new ObjectInputStream(is);
            Persona personaLeida = (Persona) ois.readObject();
            

            base64EncryptedString = "Edad:  "+personaLeida.getEdad()+",   Nombre:  "+personaLeida.getNombre();

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        }
        return base64EncryptedString;
    }
}
