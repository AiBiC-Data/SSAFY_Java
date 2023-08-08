package sol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Swea1225 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		for (int tc = 1; tc < 11; tc++) {
			int T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			Queue<Integer> queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int tmp=0;
			while(true){
				for (int i = 1; i < 6; i++) {
					tmp = queue.poll();
					tmp-=i;
					if (tmp<=0) {
						tmp=0;
						queue.add(tmp);
						break;
					}
					queue.add(tmp);
				}
				if (tmp==0) break;
			}
			while(!queue.isEmpty()) {
				sb.append(queue.poll()+" ");
			}
			System.out.println(sb.toString());
		}
	}

}
