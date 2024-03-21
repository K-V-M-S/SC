import java.util.*;
public class OtpWaste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pt = sc.nextLine();
        String key = sc.nextLine();

        if(key.length() != pt.length()){
            return;
        }

        StringBuilder ct = new StringBuilder();

        for(int i = 0; i<pt.length(); i++){
            char c = (char)(((pt.charAt(i) - 'a' + key.charAt(i) - 'a') % 26) + 'a');
            ct.append(c);
        }

        System.out.println("Encrypted text : "+ct.toString());
        // for(int i = 0; i<ct.length(); i++){
        //     System.out.print(Integer.toBinaryString((int)ct.charAt(i))+" ");
        // }

        StringBuilder dt = new StringBuilder();
        for(int i = 0; i<ct.length();i++){
            char c = (char)(((ct.charAt(i) - 'a' - (key.charAt(i) - 'a') + 26) % 26) + 'a');
            dt.append(c);
        }

        System.out.println("Decrypted : "+dt.toString());
    }
}
