package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 메모리: 14304KB
 * 시간: 124ms
 * 시간복잡도: 4^N/2
 * 분할정복으로 구역을 나누고 합을 전부 더하는데 더합 합이 전부 0이 되거나 전부 1이 되면 찾는 값이 되고 아니면 계속 나눠준다 
 */
public class S1992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line[j]-'0';
			}
		}
		divide(0,0,N);
		System.out.println(sb);
	}
	
	private static void divide(int x, int y, int size) {
		int num = 0;
		for (int r = x; r < x + size; r++) {
			for (int c = y; c < y + size; c++) {
				num+=arr[r][c];
			}
		}
		if (num == 0) { 
			sb.append("0");
		} else if (num == size * size) {
			sb.append("1");
		}else {
			int half = size/2;
			sb.append("(");
			divide(x, y, half); 
			divide(x, y+half, half); 
			divide(x+half, y, half); 
			divide(x+half, y+half, half); 
			sb.append(")");
		}
	}
}
