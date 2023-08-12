package sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1288 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int total = (1 << 10) - 1;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());

			int chkNum = 0;
			int cnt = 0;
			for (cnt = 1;; cnt++) {
				char[] arr = String.valueOf(N * cnt).toCharArray();
				for (char c : arr) {
					int num = c - '0';
					chkNum |= 1 << num;
				}
				if (chkNum == total)
					break;
			}
			sb.append(N*cnt).append("\n");
		}
		System.out.println(sb);
	}
}
