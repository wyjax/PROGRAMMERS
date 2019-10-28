import java.util.*;

public class test {
    static int n = 46;
    static long cnt = 0;
    public static void main(String []args) {
        search(0);
        System.out.println(cnt);
    }

    public static void search(int sum) {
        if(sum == (n - 1)) {
            cnt++;
            return;
        }
        else if (sum == n)
            return;

        search(sum + 1);
        search(sum + 2);

    }
}