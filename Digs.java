import java.security.*;

public class Digs {

    static String SIGNING_ALGORITHM = "SHA256withRSA";
    static int KEY_SIZE = 2048;

    public static byte[] createDigitalSignature(byte[] input, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(input);
        return signature.sign();
    }

    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(KEY_SIZE);
        return keyPairGenerator.generateKeyPair();
    }

    public static boolean verifyDigitalSignature(byte[] input, byte[] signature, PublicKey publicKey) throws Exception {
        Signature verifier = Signature.getInstance(SIGNING_ALGORITHM);
        verifier.initVerify(publicKey);
        verifier.update(input);
        return verifier.verify(signature);
    }

    public static void main(String[] args) throws Exception {
        String input = "Hello!";
        KeyPair keyPair = generateRSAKeyPair();
        byte[] signature = createDigitalSignature(input.getBytes(), keyPair.getPrivate());
        System.out.println("Signature Value:\n " + bytesToHex(signature));
        System.out.println("Verification: " + verifyDigitalSignature(input.getBytes(), signature, keyPair.getPublic()));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
