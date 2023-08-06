package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1989 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			sb.append("#" + tc + " ");
			String ispan = br.readLine();
			String tmp = "";
			for (int i = ispan.length()-1; i >=0 ; i--) {
				tmp += ispan.charAt(i);
			}
			if (ispan.equals(tmp))
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
