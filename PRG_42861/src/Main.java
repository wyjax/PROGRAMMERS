import java.util.Arrays;
import java.util.Comparator;

class Solution {
	int max = 0;
	boolean[] check;
	boolean[] ok;
	
	// �ּ� ���д� Ʈ��
	// ũ�罺Į �˰��� �̿�

	public int solution(int n, int[][] costs) {
		// �ּ� ����� �������� �ϱ⿡ �������� ����
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		check = new boolean[costs.length];
		ok = new boolean[n];

		ok[costs[0][0]] = true;
		ok[costs[0][1]] = true;
		check[0] = true;

		int answer = costs[0][2]; // ���� �ٸ� ������ ��
		int cnt = 2; // ok 2�� ����־�����

		while (cnt < n) {
			for (int i = 1; i < costs.length; i++) {
				if (check[i] || (ok[costs[i][0]] && ok[costs[i][1]]) || (!ok[costs[i][0]] && !ok[costs[i][1]]))
					continue;

				ok[costs[i][0]] = true;
				ok[costs[i][1]] = true;
				check[i] = true;
				cnt++;
				answer += costs[i][2];
				break;
			}
		}

		return answer;
	}
}

public class Main {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		new Solution().solution(4, arr);
	}
}
/*
 * 0 1 2 3
 * 
 * n n n n
 */