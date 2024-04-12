import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.*;

public class DigitalSig {
    public static void main(String args[]) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter msg");
        String msg = sc.nextLine();

        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(keyPair.getPrivate());
        sign.update(msg.getBytes());
        byte[] signature = sign.sign();

        System.out.println("Digital signature: " + Base64.getEncoder().encodeToString(signature));
        
    }
}
