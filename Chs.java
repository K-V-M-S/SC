import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Chs {

    public static String md5Hash(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String sha256Hash(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the data to be hashed: ");
        String data = scanner.nextLine();

        try {
          
            String md5Result = md5Hash(data);
            System.out.println("MD5 Hash: " + md5Result);

          
            String sha256Result = sha256Hash(data);
            System.out.println("SHA-256 Hash: " + sha256Result);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Hashing algorithm not found: " + e.getMessage());
        }
    }
}
