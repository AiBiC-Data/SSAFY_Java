package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class Swea9229 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans;
	static int[] snacks;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < TC + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				snacks[n] = Integer.parseInt(st.nextToken());
			}
			ans=-1;
			comb(0,0,0);
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	private static void comb(int dep, int flag, int sum) {
		if(dep==2) {
			if(sum<=M)	ans = Math.max(sum, ans);
			return;
		}
		for (int i = flag; i < N; i++) {
			comb(dep+1, i+1,sum+snacks[i]);
		}
	}

}
