import java.util.Scanner;

public class Exp1 {
    public static void encrypt(String text, int key) {
        String ct = "";
        String a = "abcdefghijklmnopqrstuvwxyz";
        String lt = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = lt.charAt(i);

            if (Character.isLetter(c)) {
                int x = a.indexOf(c);
                x = (x + key) % 26;
                ct = ct + a.charAt(x);
            } else {
                ct = ct + c;
            }
        }

        System.out.println("Encrypted Text: " + ct);
        System.out.println("Crypt Analysis\nKey  Text");
        int m = 1;
        for (int i = 25; i != -1; i--) {
            String dt = "";
            key = i;

            for (int j = 0; j < text.length(); j++) {
                char c = ct.charAt(j);

                if (Character.isLetter(c)) {
                    int x = a.indexOf(c);
                    x = (x + key) % 26;
                    dt = dt + a.charAt(x);
                } else {
                    dt = dt + c;
                }
            }
            System.out.println(m + ".  " + dt);
            m++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Plain Text:");
        String t = sc.nextLine();
        System.out.println("Enter the shift key:");
        int k = sc.nextInt();
        System.out.print("Encrypted Text: ");
        encrypt(t, k);
    }
}
