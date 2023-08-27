package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class G2252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb= new StringBuilder();
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static int[] inDegree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		inDegree = new int[N + 1];
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[B].add(A);
			inDegree[A] = B;
		}
		visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (inDegree[i] == 0 && !visited[i]) {
				dfs(i);
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int i) {
		visited[i] = true;
		for (int j = 0, end = adjList[i].size(); j < end; j++) {
			if (!visited[adjList[i].get(j)]) {
				dfs(adjList[i].get(j));
			}
		}
		sb.append(i+" ");
	}
}
