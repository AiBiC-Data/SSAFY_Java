package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1244 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		boolean[] switches = new boolean[T];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			switches[i] = (st.nextToken().equals("0") ? false : true);
		}

		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());

			if (st.nextToken().equals("1")) {
				// 남자면
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < T; j++) {
					if ((j + 1) % n == 0) {
						switches[j] = !switches[j];
					}
				}
			} else {
				// 여자면
				int n = Integer.parseInt(st.nextToken()) - 1;
				switches[n] = !switches[n];
				int cnt = 1;
				while (true) {
					if (n - cnt < 0 || n + cnt >= T || (switches[n - cnt] != switches[n + cnt])) {
						break;
					}
					switches[n - cnt] = !switches[n - cnt];
					switches[n + cnt] = !switches[n + cnt];
					cnt++;
				}
			}
		}
		for (int j = 0; j < T; j++) {
			System.out.print((switches[j] == true ? 1 : 0) + " ");
			if ((j + 1) % 20 == 0)
				System.out.println();
		}
	}
}