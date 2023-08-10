package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class G17406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int ans,N,M,K;
	static int[][] nums, arr;
	static boolean[] visit;
	static ArrayDeque<int[]> queue;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[K];
		nums = new int[K][3];
		queue = new ArrayDeque<>();
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			nums[i][0]= r-1;
			nums[i][1]= c-1;
			nums[i][2]= s;
		}
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int dep) {
		if (dep==K) {
			ArrayDeque<int[]>que = queue.clone();
			ans = Math.min(ans, rotate(que));
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			queue.add(nums[i]);
			dfs(dep+1);
			visit[i]=false;
			queue.pollLast();
		}
	}
	private static int rotate(ArrayDeque<int[]> q) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		while(!q.isEmpty()) {
			int[] inq = q.poll();
			int x = inq[0];
			int y = inq[0];
			int z = inq[0];
			int lx = x-z;
			int ly = y-z;
			int rx = x+z;
			int ry = y+z;
			while(true) {
				if(lx >= rx || ly >= ry) break;
				int dir=0;
				x = lx;
				y = ly;
				int past = tmp[lx][ly];
				while(true) {
					int nx = x+dx[dir];
					int ny = y+dy[dir];
					if(!(lx<=nx&&nx<=rx)||!(ly<=ny&&ny<=ry)) {
						dir +=1;
						dir %=4;
						continue;
					}
					int temp = tmp[nx][ny];
					tmp[nx][ny] = past;
					past = temp;
					x = nx;
					y = ny;
					if (x==lx && y==ly) {
						lx+=1;
						ly+=1;
						rx-=1;
						ry-=1;
						break;
					}
				}
				
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum=0;
			for (int j = 0; j < N; j++) {
				sum+=tmp[i][j];
			}
			answer = Math.min(answer, sum);
		}
		System.out.println("!");
		return answer;
	}
}