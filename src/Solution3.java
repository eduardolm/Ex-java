import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution3 {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int a = 0, b = 0, n = 0;
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();

            int x = 0;
            int resp = a;
            if (!output.isEmpty()) {
                System.out.println();
                output.clear();
            }
            for (x = 0; x < n; x++) {
                resp += (int) (Math.pow(2, x) * b);
                output.add(resp);
            }
            for (int item : output) {
                System.out.print(item + " ");
            }
        }
        in.close();
    }
}