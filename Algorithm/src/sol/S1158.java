package sol;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S1158 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb.append("<");
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new ArrayDeque<>();
		int[] result = new int[N];
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int count = 0;
		int index=0;
		while(queue.size() > 0) {
			count += 1;
			if (count == K) {
				result[index++]=queue.poll();
				count = 0;
			} else {
				queue.add(queue.poll());				
			}
		}
		for (int i = 0; i < N; i++) {
			if (i==N-1) {
				sb.append(result[i]+">");
				continue;
			}
			sb.append(result[i]+", ");
		}
		System.out.println(sb.toString());
	}
}
