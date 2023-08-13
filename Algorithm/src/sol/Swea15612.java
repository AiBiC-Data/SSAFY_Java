package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea15612 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + " ");
			boolean[] visit = new boolean[8];
			boolean flag = false;
			int look=0;
			for (int i = 0; i < 8; i++) {
				String st = br.readLine();
				String[] s = st.split("");
				int cnt=0;
				for (int j = 0; j < 8; j++) {
					if (s[j].equals("O")) {
						if (visit[j]) {
							flag = true;
							break;
						}
						visit[j] = true;
						++cnt;
						++look;
						if(cnt>1) {
							flag=true;
							break;
						}
					}
				}
				if (flag) continue;
			}
			if (flag || look!=8) sb.append("no\n");
			else sb.append("yes\n");
		}
		System.out.println(sb);
	}
}
