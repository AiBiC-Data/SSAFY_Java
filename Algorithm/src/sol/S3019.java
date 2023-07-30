package sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3019 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken()) - 1;
		int[][][] shape = { { { 0 }, { 0, 0, 0, 0 } }, { { 0, 0 } }, { { 0, 0, 1 }, { 1, 0 } },
				{ { 1, 0, 0 }, { 0, 1 } }, { { 0, 0, 0 }, { 0, 1 }, { 1, 0, 1 }, { 1, 0 } },
				{ { 0, 0, 0 }, { 0, 0 }, { 0, 1, 1 }, { 2, 0 } }, { { 0, 0, 0 }, { 0, 0 }, { 1, 1, 0 }, { 0, 2 } } };
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[C];
		for (int i = 0; i < C; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for (int i = 0; i < shape[P].length; i++) {
			for (int j = 0; j < C - shape[P][i].length + 1; j++) {
				int diff = arr[j] - shape[P][i][0];
				boolean flag = true;
				for (int k = 0; k < shape[P][i].length; k++) {
					if (diff != arr[j + k] - shape[P][i][k]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					cnt++;
				}
			}

		}
		System.out.println(cnt);
	}
}
