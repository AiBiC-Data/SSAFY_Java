package sol;

import java.util.Scanner;

public class Swea1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int x = 0;
			int y = 0;
			int flag = 1;
			for (int j = 1; j < n * n + 1; j++) {
				arr[x][y] = j;
				if (flag == 1) {
					y++;
					if (y>=n||arr[x][y]!=0) {
						y--;
						x++;
						flag=2;}
				}else if (flag==2) {
					x++;
					if (x>=n||arr[x][y]!=0) {
						x--;
						y--;
						flag=3;}
					
				}else if (flag==3) {
					y--;
					if (y<0||arr[x][y]!=0) {
						y++;
						x--;
						flag=4;}
				}
				else if (flag==4) {
					x--;
					if (x<0||arr[x][y]!=0) {
						x++;
						y++;
						flag=1;}
				}
			}

			System.out.printf("#%d%n", i);
			for (int j = 0; j < n; j++) {
				for (int k:arr[j]) {
					System.out.print(k+" ");
				}
				System.out.println();
			}
		}
	}

}
