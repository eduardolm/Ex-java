import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();

            if (x <= 99) {
                String z = "0" + x;
                if (x < 10) {
                    z = "00" + x;
                }
                System.out.printf("%-15s%s\n", s1, z);
            }
            else {
                System.out.printf("%-15s%s\n", s1, x);
            }
        }
        System.out.println("================================");

    }
}
