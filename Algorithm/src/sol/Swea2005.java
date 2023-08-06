package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2005 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String str;
	static String tmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + "\n");
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					if (j == 0 || j == i) {
						arr[i][j] = 1;
						continue;
					}
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
