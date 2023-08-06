package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Swea {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			HashSet<Character> set = new HashSet();
			sb.append("#" + tc + " ");
			int n = Integer.parseInt(br.readLine());
			int cnt =1;
			while(true) {
				if(set.size()==10) break;
				String tmp = Integer.toString(n*cnt);
				for (int i = 0; i < tmp.length(); i++) {
					set.add(tmp.charAt(i));
				}
				cnt++;
			}
			sb.append(n*(cnt-1)+"\n");
		}
		System.out.println(sb.toString());
	}
}
