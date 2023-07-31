package sol;

import java.util.Scanner;

public class S1913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[][] arr = new int[n][n];
		int val=1;
		int x=n/2, y=n/2;
		int lmt=1;
		while(true) {
			for(int i=0;i<lmt;i++) {
				arr[x--][y]=val++;
			}
			if (val-1==n*n) break;
			for (int i = 0; i < lmt; i++) {
				arr[x][y++]=val++;
			}
			lmt++;
			for (int i = 0; i < lmt; i++) {
				arr[x++][y]=val++;
			}
			for (int i = 0; i < lmt; i++) {
				arr[x][y--]=val++;
			}
			lmt++;
		}
		StringBuilder sb = new StringBuilder();
		int tx=0, ty=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (target==arr[i][j]) {
					tx=i+1;
					ty=j+1;
				}
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		sb.append(tx+" "+ty);
		System.out.println(sb.toString());
	}
}
