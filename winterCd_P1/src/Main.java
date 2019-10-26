class Solution {
    public int gcd(int h, int w) {
        if (w == 0)
            return h;
        else {
            return gcd(w, h % w);
        }
    }

    public long solution(int w, int h) {
        long answer = 0;
        long avail = w * h;

        if (h < w) {
            int tmp = h;
            h = w;
            w = tmp;
        }
        if (w == 1)
            return 0;
        else if (w == h)
            return avail - w;

        int zz = gcd(h, w);
        int x = w / zz;
        int y = h / zz;
        answer = (x + y - 1) * zz;
        avail -= answer;

        return avail;
    }
}

public class Main {
    public static void main(String []args) {
        System.out.println(new Solution().solution(5, 12));
    }
}