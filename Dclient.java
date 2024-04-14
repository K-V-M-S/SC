import java.util.*;
import java.net.*;
import java.io.*;

public class Dclient {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter prime and generator : ");
        int p = sc.nextInt();
        int g = sc.nextInt();
        Random r = new Random();

        int a = r.nextInt(g);
        System.out.println("Private key : "+a);
        int x = (int)(Math.pow(g, a) % p);

        Socket client = new Socket("localhost",8988);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeInt(p);
        out.writeInt(g);
        out.writeInt(x);

        DataInputStream in = new DataInputStream(client.getInputStream());
        int y = in.readInt();

        int key = (int)(Math.pow(y, a) % p);
        System.out.println("Secret Key : "+key);
    }
}
