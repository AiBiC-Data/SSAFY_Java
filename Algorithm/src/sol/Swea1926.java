package sol;

import java.util.Scanner;

public class Swea1926 {
	static String tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < N+1; i++) {
			tmp = Integer.toString(i);
			int cnt=0;
			for (int j = 0; j < tmp.length(); j++) {
				if ((int)tmp.charAt(j)!=48&&((int)tmp.charAt(j)-48)%3==0) {
					cnt++;
				}
			}
			if (cnt!=0) {
				String s ="";
				for (int j = 0; j < cnt; j++) {
					s+="-";
				}sb.append(s+" ");
			}else {
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString());
	}
}
