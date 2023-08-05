package sol;

import java.util.*;
import java.io.*;

public class S11659 {
	static int N, M;
	static int a,b;
	static int ans;
	static int[] num;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N+1];
		for (int i = 1; i <= N; i++) {
			num[i] = sc.nextInt() + num[i-1];
		}
		
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			ans = 0;
			ans = num[b] - num[a-1];
			
			System.out.println(ans);
		}
	}
}













