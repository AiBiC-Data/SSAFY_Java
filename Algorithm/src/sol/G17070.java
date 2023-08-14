package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17070 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };
	static int cnt, N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	static void dfs(int x, int y, int dir) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}
		if (dir == 0) {
			for (int j = 0; j < 2; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || map[nx][ny]==1) 
					continue;
				if(j==1) {
					if(map[nx-1][ny]==1||map[nx][ny-1]==1) continue;
				}
				dfs(nx, ny, j);
			}
		}
		else if (dir == 2) {
			for (int j = 1; j < 3; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1|| map[nx][ny]==1)
					continue;
				if(j==1) {
					if(map[nx-1][ny]==1||map[nx][ny-1]==1) continue;
				}
				dfs(nx, ny, j);
			}
		}
		else {
			for (int j = 0; j < 3; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1|| map[nx][ny]==1)
					continue;
				if(j==1) {
					if(map[nx-1][ny]==1||map[nx][ny-1]==1) continue;
				}
				dfs(nx, ny, j);
			}
		}

	}
}
