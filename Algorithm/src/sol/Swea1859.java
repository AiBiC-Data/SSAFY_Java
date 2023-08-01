package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Swea1859 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] prices = new int[N];
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int cnt=-1;
			long ans=0;
			for (int i = N-1; i >=0; i--) {
				if(prices[i]>cnt) {
					cnt = prices[i];
				}
				ans +=cnt-prices[i];
			}
			System.out.printf("#%d %d%n", tc, ans);
		}
	}

}
