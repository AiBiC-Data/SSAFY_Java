package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G2493 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] tops = new int[N];
		int[] ans = new int[N];
		Stack<int[]> stack = new Stack<int[]>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && tops[i] > stack.peek()[1]) {
				if (tops[i] <= stack.peek()[1]) {
					ans[i] = stack.peek()[0];
					stack.add(new int[] { i + 1, tops[i] });
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[i] = 0;
				stack.add(new int[] { i + 1, tops[i] });
			} else {
				ans[i] = stack.peek()[0];
				stack.add(new int[] { i + 1, tops[i] });
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
