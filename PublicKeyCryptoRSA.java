import java.util.*;
import java.math.BigInteger;
import java.security.*;

public class PublicKeyCryptoRSA{

    static BigInteger one = new BigInteger("1");
    static SecureRandom r = new SecureRandom();
    BigInteger p,q,e,d,n,phi;

    public PublicKeyCryptoRSA(int N){
        p = BigInteger.probablePrime(N/2, r);
        q = BigInteger.probablePrime(N/2, r);
        n = p.multiply(q);
        phi = (p.subtract(one)).multiply(q.subtract(one));
        
        do{
            e = BigInteger.probablePrime(N/2, r);
        }while(e.compareTo(phi)>=0 || !e.gcd(phi).equals(one));

        d = e.modInverse(phi);
        System.out.println("p : "+p+"\nq : "+q+"\ne : "+e+"\nd : "+d);

    }

    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();

        PublicKeyCryptoRSA key = new PublicKeyCryptoRSA(10);

        BigInteger msg = new BigInteger(m);
        BigInteger enc = msg.modPow(key.e,key.n);
        BigInteger dec = msg.modPow(key.d,key.n);

        System.out.println("Message : "+m);
        System.out.println("Encrypted : "+enc);
        System.out.println("Decrypted : "+dec);

    }
}
