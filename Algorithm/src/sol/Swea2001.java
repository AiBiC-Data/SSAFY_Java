package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2001 {
	static int N, M;
	static int[][] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int ans=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			num = new int[N+1][N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					num[i][j] = Integer.parseInt(st.nextToken())+num[i-1][j]+num[i][j-1]-num[i-1][j-1];
				}
			}
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if((i-M)<0||(j-M)<0) continue;
					int tmp = num[i][j] - (num[i-M][j] + num[i][j-M] - num[i-M][j-M]);
					ans = Math.max(ans, tmp);
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
