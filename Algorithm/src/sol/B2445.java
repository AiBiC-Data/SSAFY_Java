package sol;

import java.util.Scanner;

public class B2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		int blk=1;
		for (int i = 0; i <t; i++) {
			String st="";
			for (int j = 0; j < 2*t; j++) {
				if (j<blk) {
					st+="*";
				}
				else if (j<2*t-blk) {
					st+=" ";
				}else {
					st+="*";
				}
			}
			blk++;
			System.out.println(st);
		}
		blk=t-1;
		for (int i = t; i >0; i--) {
			String st="";
			for (int j = 0; j < 2*t; j++) {
				if (j<blk) {
					st+="*";
				}
				else if (j<2*t-blk) {
					st+=" ";
				}else {
					st+="*";
				}
			}
			blk--;
			System.out.println(st);
		}
	}
}
