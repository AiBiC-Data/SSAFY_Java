package sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1230 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> alist;

	public static void main(String[] args) throws Exception {
		for (int tc = 1; tc < 11; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			alist = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				alist.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				char tmp = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				func(tmp, num);
				
			}
			for (int i = 0; i < 10; i++) {
				sb.append(alist.get(i)+" ");
			}
			sb.append("\n");
		} 
		System.out.println(sb);
	}
	static void func(char ch, int x) {
		int y;
		switch(ch) {
		case 'I':
			y = Integer.parseInt(st.nextToken());
			for (int i = 0; i < y; i++) {
				alist.add(x++, Integer.parseInt(st.nextToken()));
			}
			break;
		case 'D':
			y = Integer.parseInt(st.nextToken());
			for (int i = 0; i < y; i++) {
				alist.remove(x);
			}
			break;
		case 'A':
			for (int i = 0; i < x; i++) {
				alist.add(Integer.parseInt(st.nextToken()));
			}
			break;
		}
	}
}