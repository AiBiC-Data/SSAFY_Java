package sol;

import java.util.*;
import java.io.*;

public class S11660 {
	static int N, M;
	static int[][] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N + 1][N + 1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				num[i][j] = Integer.parseInt(st.nextToken())+num[i-1][j]+num[i][j-1]-num[i-1][j-1];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int tmp = num[x2][y2] - (num[x1-1][y2] + num[x2][y1-1] - num[x1-1][y1-1]);
			System.out.println(tmp);
		}

	}
}
