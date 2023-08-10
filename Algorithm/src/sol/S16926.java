package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MyList {
	int x;
	int y;
	MyList next = null;

	MyList() {
	}

	MyList(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][] ans = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = Math.min(N, M) / 2;
		MyList[] li = new MyList[count];
		MyList head;
		for (int i = 0; i < count; i++) {
			int size = 0;
			head = new MyList(0, 0);
			MyList llist = new MyList(0, 0);
			llist = head;

			for (int j = i; j < N - i; j++) {
				llist.next = new MyList(j, i);
				llist = llist.next;
				size++;
			}
			for (int j = i + 1; j < M - i; j++) {
				llist.next = new MyList(N - 1 - i, j);
				llist = llist.next;
				size++;
			}
			for (int j = N - 1 - i; j > i; j--) {
				llist.next = new MyList(j - 1, M - i - 1);
				llist = llist.next;
				size++;
			}
			for (int j = M - i - 2; j > i; j--) {
				llist.next = new MyList(i, j);
				llist = llist.next;
				size++;
			}
			li[i] = head;
			llist.next = head.next;
			head.x = size;
		}
		for (int i = 0; i < count; i++) {
			MyList curr = li[i].next;
			for (int j = 0, size = R % li[i].x; j < size; j++) {
				curr = curr.next;
			}
			MyList tmp = li[i].next;
			for (int j = 0, size = li[i].x; j < size; j++) {
				ans[curr.x][curr.y] = arr[tmp.x][tmp.y];
				tmp = tmp.next;
				curr = curr.next;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
			
		}
	}

}

//public class S16926 {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
//	static StringBuilder sb = new StringBuilder();
//	public static void main(String[] args) throws IOException {
//		st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		
//		int[][] arr = new int[N][M];
//
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0, count = Math.min(N, M)/2; j < count; j++) {
//				int x_t = j;
//				int y_t = j;
//				int value_t = arr[x_t][y_t];
//				int tmp=0;
//				for (int k = j+1; k < N-j; k++) {
//					x_t=k;
//					tmp = arr[x_t][y_t];
//					arr[x_t][y_t] = value_t;
//					value_t = tmp;
//				}
//				for (int k = j+1; k < M-j; k++) {
//					y_t =k;
//					tmp = arr[x_t][y_t];
//					arr[x_t][y_t] = value_t;
//					value_t = tmp;
//				}
//				for (int k = j+1; k < N-j; k++) {
//					x_t =N-k-1;
//					tmp = arr[x_t][y_t];
//					arr[x_t][y_t] = value_t;
//					value_t = tmp;
//				}
//				for (int k = j+1; k < M-j; k++) {
//					y_t =M-k-1;
//					tmp = arr[x_t][y_t];
//					arr[x_t][y_t] = value_t;
//					value_t = tmp;
//				}
//			}
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				sb.append(arr[i][j]+" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
//	}
//}
