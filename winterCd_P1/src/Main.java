class Solution {
    public int gcd(int h, int w) {
        if (w == 0)
            return h;
        else {
            return gcd(w, h % w);
        }
        // 없으면 1로 간다.
    }

    public long solution(int w, int h) {
        long answer = 0;
        long avail = w * h;

        if (h < w) {
            int tmp = h;
            h = w;
            w = tmp;
        }

        int z = gcd(h, w);

        int x = w / z;
        int y = h / z;
        answer = (w + h - 1) * z;
        avail -= answer;

        return avail;
    }
}

public class Main {
    public static void main(String []args) {
        System.out.println(new Solution().solution(8, 12));
    }
}