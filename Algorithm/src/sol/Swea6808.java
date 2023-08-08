package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Swea6808 {
	static int[] gyu_card;
	static int[] in_card;
	static int count;
	static int all=1;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < 10; i++) {
			all *=i;
		}
		for (int tc = 1; tc < T+1; tc++) {
			count = 0;
			gyu_card = new int[9];
			in_card = new int[9];
			st = new StringTokenizer(br.readLine());
			boolean[] isin = new boolean[19];
			for (int i = 0; i < 9; i++) {
				gyu_card[i] = Integer.parseInt(st.nextToken());
				isin[gyu_card[i]]=true;
			}
			int ptr_i=0;
			for (int i = 1; i < 19; i++) {
				if (!isin[i]) {
					in_card[ptr_i++]=i;
				}
			}
			per(0,0,0);
			System.out.printf("#%d %d %d%n", tc, count, all-count);
		}
	}
	public static void per(int n, int flag, int score) {
		if(n==9) { // 종료 조건
			if (score > 85) count++;
		}
		for (int i = 0; i < 9; i++) {
			int tmp=score;
			if ((flag & 1 << i) != 0)
				continue;
			if (gyu_card[n]-in_card[i]>0) {
				tmp += (gyu_card[n]+in_card[i]);
			}
			per(n+1,flag|1<< i,tmp);
		}
	}
}
