package sol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SweaArrayModify {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			LinkedList<Integer> llist = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				llist.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				switch(ch) {
				case 'I':
					llist.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 'D':
					llist.remove(Integer.parseInt(st.nextToken()));
					break;
				case 'C':
					llist.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}
			if(llist.size()>L) sb.append(llist.get(L)).append("\n");
			else sb.append(-1+"\n");
		}
		System.out.println(sb);
	}

}
