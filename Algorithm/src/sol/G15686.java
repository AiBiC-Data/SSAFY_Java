package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class G15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int cnt;
	static int[][] comp;
	static ArrayList<int[]> home = new ArrayList();
	static ArrayList<int[]> chicken = new ArrayList();
	static int ans;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		comp = new int[M][];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k = sc.nextInt();
				if (k == 1) home.add(new int[] { i, j });
				else if (k == 2) chicken.add(new int[] { i, j });
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int dep, int st) {
		if (dep == M) {
			int ans2=0;
			for (int j = 0; j < home.size(); j++) {
				int sum=Integer.MAX_VALUE;
				int x_h = home.get(j)[0];
				int y_h = home.get(j)[1];
				int tmp=0;
				// 집과 치킨집들중 가까운 거리로 비교
				for (int i = 0; i < comp.length; i++) {
					int x = comp[i][0];
					int y = comp[i][1];
					tmp = (Math.abs(x-x_h)+Math.abs(y-y_h));
					if(tmp<sum) sum=tmp;
				}
				ans2 +=sum;
			}
			if (ans > ans2)	ans = ans2;
			return;
		}
		for (int i = st; i < chicken.size(); i++) {
			comp[dep] = chicken.get(i);
			comb(dep + 1, i + 1);
		}
	}
}
