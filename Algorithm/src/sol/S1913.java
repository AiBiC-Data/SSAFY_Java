package sol;

import java.util.Scanner;

public class S1913 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			int dir = 0;
			int num = 1;
			int x = 0;
			int y = -1;

			while (true) {
				if (num > n * n)
					break;
				if (x + dx[dir] < 0 || x + dx[dir] >= n || y + dy[dir] < 0 || y + dy[dir] >= n
						|| arr[x + dx[dir]][y + dy[dir]] != 0)
					dir = (dir + 1) % 4;
				x += dx[dir];
				y += dy[dir];
				arr[x][y] = num++;
			}

			System.out.printf("#%d%n", i + 1);
			for (int j = 0; j < n; j++) {
				for (int k : arr[j]) {
					System.out.print(k + " ");
				}
				System.out.println();
			}
		}
	}
}