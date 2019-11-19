import java.util.*;
import java.lang.*;
import java.io.*;

class NoOfCoin {
    static Integer[] elements;
	public static void main (String[] args) {
		//code
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int noOfTestCase = Integer.parseInt(br.readLine());
		    for (int testcount = 0; testcount < noOfTestCase; testcount++) {
		        String[] inputArray = br.readLine().split(" ");
		        int target = Integer.parseInt(inputArray[0]);
		        int noOfEle = Integer.parseInt(inputArray[1]);
		        elements = new Integer[noOfEle];
		        String[] elementString = br.readLine().split(" ");
		        for(int i=0;i<noOfEle; i++) {
		            elements[i]= Integer.parseInt(elementString[i]);
		        }
		        //sort before call
		        System.out.println(getNumberOfCoins(target, 0));
		    } 
		} catch (IOException e) {
		    e.printStackTrace();
	    }
	}
	
	static int getNumberOfCoins(int target, int startIndex) {
	    int count = 0;
	    if (startIndex<elements.length) {
	        return count;
	    }
	    if(target >= elements[startIndex]) {
	        count = target / elements[startIndex];
	        int cover = elements[startIndex] * count;
	        int due = target - cover;
            if ( due != 0 ) {
                for (int i = startIndex+1; i < elements.length; i++) {
                    count += getNumberOfCoins(due, startIndex+i); 
                    if (count != 0) {
                        break;
                    }
                }
	        } else {
	            return count;
	        }
	    }
	    return count;
	}
}
