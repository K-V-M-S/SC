import java.util.Scanner;
import java.security.*;
import java.math.*;
public class DiffieHellman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SecureRandom r = new SecureRandom();

        System.out.println("Enter prime and generator : ");
        String prime = sc.next();
        String gen = sc.next();

        BigInteger p = new BigInteger(prime);
        BigInteger g = new BigInteger(gen);

        BigInteger a = new BigInteger(1024,r);
        BigInteger b = new BigInteger(1024,r);

        BigInteger x = g.modPow(a,p);
        BigInteger y = g.modPow(b,p);

        BigInteger k1 = y.modPow(a,p);
        BigInteger k2 = x.modPow(b,p);

        if(k1.compareTo(k2) == 0 && !k1.equals(BigInteger.ZERO)){
            System.out.println(k1 + " " + k2);
        }
        else{
            System.out.println("Key Exchange failed");
        }
    }
}
