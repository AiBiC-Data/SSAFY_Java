package sol;

import java.util.Scanner;

public class S15649{
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];
		visit = new boolean[N + 1];
		
		per(0, 0);
	}

	public static void per(int cnt, int flag) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			arr[cnt] = i + 1;
			per(cnt + 1, flag | 1<<i);
		}
	}

}

