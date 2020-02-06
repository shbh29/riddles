import java.io.*;
import java.util.*;

public class Match2Sum {
	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {

			int size = Integer.parseInt(br.readLine());
			if (size == 0) break;
			int[] arr = new int[size];
			String[] input = br.readLine().split(" ");
			for(int i=0; i< size; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			do {
				int sumNo = Integer.parseInt(br.readLine());
				if (sumNo == 0) break;
				boolean res = sumMatch(arr, sumNo);
				System.out.println("Array Contains Match:" + res);

			} while(true);
		}while(true);
	}
	static boolean sumMatch(int[] arr,int sumNo) {
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum == sumNo) {
				return true;
			} else if (sum < sumNo) {
				i++;
			} else if (sum > sumNo) {
				j--;
			}
		}
		return false;
	}
}
