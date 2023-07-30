package sol;

import java.util.Scanner;

public class Swea1986 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T ; tc++) {
			int ans=0;
			int n = sc.nextInt();
			for (int i = 1; i < n+1; i++) {
				if(i%2==0)
					ans-=i;
				else
					ans+=i;
			}
			System.out.printf("#%d %d%n", tc, ans);
		}
	}
}
