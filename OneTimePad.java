import java.util.Scanner;

public class OneTimePad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Plain Text:");
        String pt = sc.nextLine();
        System.out.println("Enter the shift key:");
        String key = sc.nextLine();

        if(pt.length() != key.length()){
            System.out.println("Key and plain text should be of same length");
            return;
        }
        StringBuilder ct = new StringBuilder();
        for(int i = 0; i<pt.length(); i++){
            char c = (char)(pt.charAt(i) ^ key.charAt(i));
            ct.append(c);
        }

        System.out.println("Encrypted Text : ");
        for(int i = 0; i<ct.length();i++){
            System.out.print(Integer.toBinaryString((int)ct.charAt(i))+" ");
        }

        StringBuilder dt = new StringBuilder();
        for(int i = 0; i<ct.length(); i++){
            char c = (char)(ct.charAt(i) ^ key.charAt(i));
            dt.append(c);
        }

        System.out.println("\nDecrypted Text : "+dt.toString());

        
    }
    
}
