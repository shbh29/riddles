/**
 * From the given array, get the two numbers that add up for a target number.
 */
import java.util.HashMap;
import java.util.Map;

class AddPair {
	public static void main(String... args){
		int target = 9;
		int[] array = {4,6,2,6,7,2,8};
		for(int i=0;i<array.length;i++){
			for(int j=i+1; j<array.length;j++){
				if(array[i]+array[j]==target){
					System.out.println("for array of {4,6,2,6,7,2,8}: ["+i+", "+j+"]");
					break;
				}
			}
		}

		/**
		 * Using HashMap
		 */
		Map arrayMap = new HashMap<Integer, Integer>();
		int complement = 0, j = 0;
		for(int i=0;i<array.length;i++){
			arrayMap.put(array[i], i);
			complement = array[i]-target<0 ? target - array[i] : array[i] - target;
			if(arrayMap.containsKey(complement)){
				System.out.println("for array of {4,6,2,6,7,2,8}: ["+arrayMap.get(array[i])+", "+arrayMap.get(complement)+"]");
			}
		}
	}
}
