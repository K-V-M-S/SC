import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class MAC {

    public static void main(String[] args) throws Exception{
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Secret Key: ");
            String secretKey = scanner.nextLine();

            System.out.print("Enter Message: ");
            String message = scanner.nextLine();

            String generatedMAC = generateMAC(secretKey, message);
            System.out.println("Generated MAC: " + generatedMAC);

            boolean isVerified = verifyMAC(secretKey, message, generatedMAC);
            System.out.println("MAC Verification Result: " + isVerified);
    }

    private static String generateMAC(String secretKey, String message)
            throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmac = initHMAC(secretKey);
        return Base64.getEncoder().encodeToString(hmac.doFinal(message.getBytes()));
    }

    private static boolean verifyMAC(String secretKey, String message, String receivedMAC)
            throws NoSuchAlgorithmException, InvalidKeyException {
        String generatedMAC = generateMAC(secretKey, message);
        return generatedMAC.equals(receivedMAC);
    }

    private static Mac initHMAC(String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmac = Mac.getInstance("HmacSHA256");
        hmac.init(new SecretKeySpec(secretKey.getBytes(), "HmacSHA256"));
        return hmac;
    }
}