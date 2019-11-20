/**
 * Sort Given Array with Binary elements using one loop only.
 * e.g: [0, 1,0,0,1,1,0] = [0,0,0,0,1,1,1]
 * NOTE: NO another array to be used.
 */
import java.io.*;
import java.util.*;

class SortBinaryArray {
	public static void main(String ...args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Enter Binary Elements of Array: ");
			int length = Integer.parseInt(br.readLine());
			Integer[] arr = new Integer[length];
			for(int i = 0; i < length; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			int zeroIndex =  0,oneIndex =  arr.length - 1;

			while(zeroIndex < oneIndex) {
				if (arr[zeroIndex]==0){
					zeroIndex++;
				} else {
					int temp = arr[zeroIndex];
					arr[zeroIndex] = arr[oneIndex];
					arr[oneIndex] = temp;
					oneIndex--;
				}
			}
			List<Integer> list =Arrays.asList(arr);
			System.out.println("Sorted Array is: "+ list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

