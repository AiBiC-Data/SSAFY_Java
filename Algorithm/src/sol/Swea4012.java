package sol;
import java.util.*;
import java.io.*;

class Swea4012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] foods;
	static int N, T, C, sum;
	static int[] num, temp, idx;
	static ArrayList<Integer> ans;
	public static void main(String args[]) throws Exception {

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T+1; tc++) {
			int answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			
			
			// 상삼각으로 몰기
			foods = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (i > j)
						foods[j][i] += tmp;
					else if (i == j)
						continue;
					else
						foods[i][j] += tmp;
				}
			}

			C = N/2;
			num = new int[C];
			idx = new int[N];
			for (int i = 0; i < N; i++) {
				idx[i]=i+1;
			}
			ans = new ArrayList<>();
			comb(0, 0);
			
			for (int i = 0; i < ans.size()/2; i++) {
				int temp = Math.abs(ans.get(i) - ans.get(ans.size()-1-i));
				answer = Math.min(temp, answer);
			}
			
			System.out.printf("#%d %d%n",tc,answer);
		}
	}

	private static void comb(int dep, int flag) {
		if (dep == C) {
			sum = 0;
			temp = new int[C];
			comb2(0, 0);
			ans.add(sum);
			return;
		}

		for (int i = flag; i < N; i++) {
			num[dep] = idx[i];
			comb(dep + 1, i + 1);
		}
	}

	private static void comb2(int dep, int flag) {
		if (dep == 2) {
			sum += foods[temp[0]-1][temp[1]-1];
			return;
		}

		for (int i = flag; i < C; i++) {
			temp[dep] = num[i];
			comb2(dep + 1, i + 1);
		}
	}

}