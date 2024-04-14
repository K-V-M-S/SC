import java.net.*;
import java.util.Random;
import java.io.*;

public class Dserver {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8988);
        Socket server = ss.accept();
        Random r = new Random();

        DataInputStream in = new DataInputStream(server.getInputStream());
        int p = in.readInt();
        int g = in.readInt();
        int x = in.readInt();
        int b = r.nextInt(g);
        System.out.println("Private key : "+b);
        int y = (int)(Math.pow(g, b) % p);

        DataOutputStream out = new DataOutputStream(server.getOutputStream());
        out.writeInt(y);

        int key = (int)(Math.pow(x, b) % p);
        System.out.println("Secret Key: " + key);
    }
}
