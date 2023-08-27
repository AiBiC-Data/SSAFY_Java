package sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class G10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static boolean[][] visit;
	static int ans1, ans2, N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					ans1++;
					visit[i][j] = true;
					bfs(i, j);
				}

			}
		}
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					ans2++;
					visit[i][j] = true;
					bfs2(i, j);
				}

			}
		}
		System.out.println(ans1 + " " + ans2);

	}

	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || visit[nx][ny])
					continue;
				if (map[tmp[0]][tmp[1]] == map[nx][ny]) {
					visit[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}

	}

	static void bfs2(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || visit[nx][ny])
					continue;
				if(map[tmp[0]][tmp[1]]=='B') {
					if(map[nx][ny]=='B') {
						visit[nx][ny]=true;
						q.offer(new int[] {nx,ny});
					}
				} else {
					if (map[nx][ny] != 'B') {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}

	}

}
