package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea0817 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int H, W, nx,ny;
	static char map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[] where = {'^','v','<','>'};
	static Tank tank;

	static class Tank {
		int x;
		int y;
		int look;

		public Tank(int x, int y, int look) {
			this.x = x;
			this.y = y;
			this.look = look;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = ch[j];
					if (ch[j] == '^') {
						tank = new Tank(i,j, 0);
						map[i][j]='.';
					} else if (ch[j] == 'v') {
						tank = new Tank(i,j, 1);
						map[i][j]='.';
					} else if (ch[j] == '<') {
						tank = new Tank(i,j, 2);
						map[i][j]='.';
					} else if (ch[j] == '>') {
						tank = new Tank(i,j, 3);
						map[i][j]='.';
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			char[] str = br.readLine().toCharArray();
			
			for (int i = 0; i < N; i++) {
				char command = str[i];
				if (command == 'U') {
					moveTank( 0);
				} else if (command == 'D') {
					moveTank(1);
				} else if (command == 'L') {
					moveTank(2);
				} else if (command == 'R') {
					moveTank(3);
				} else if (command == 'S') {
					nx = tank.x;
					ny = tank.y;
					int dir = tank.look;
					while (true) {
						nx += dx[dir];
						ny += dy[dir];
						if (nx < 0 || ny < 0 || nx >= H || ny >= W)
							break;
						if (map[nx][ny] == '*') {
							map[nx][ny] = '.';
							break;
						} else if (map[nx][ny] == '#') {
							break;
						}
					}
				}
			}
			map[tank.x][tank.y] = where[tank.look];
			sb.append("#" + tc + " ");
			for (char[] cha : map) {
				for (char ch : cha) {
					sb.append(ch);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}


	static void moveTank(int dir) {
		nx = tank.x + dx[dir];
		ny = tank.y + dy[dir];
		if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
			tank.look = dir;
			return;
		}
		if (map[nx][ny] == '.') {
			tank.x = nx;
			tank.y = ny;
		}
		tank.look = dir;
	}
}
