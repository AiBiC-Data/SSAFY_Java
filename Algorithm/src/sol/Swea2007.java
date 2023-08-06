package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2007 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String str;
	static String tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			sb.append("#"+tc+" ");
			str = br.readLine();
			tmp = "";
			for (int i = 0; i < str.length(); i++) {
				tmp+=str.charAt(i);
				if(str.startsWith(tmp, tmp.length())) {
					sb.append((i+1)+"\n");
					break;				}
			}
		}
		System.out.println(sb.toString());
	}

}
