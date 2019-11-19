
import java.util.*;
import java.lang.*;
import java.io.*;

class NoOfCoin {

    static Integer[] elements;

    public static void main(String[] args) {
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
                for (int i = 0; i < noOfEle; i++) {
                    elements[i] = Integer.parseInt(elementString[i]) > target ? 0 : Integer.parseInt(elementString[i]);
                }
                //bubble sort
                for(int i=0; i<elements.length; i++) {
                    for(int j=i+1; j<elements.length; j++) {
                        if (elements[i] < elements[j]) {
                            int temp = elements[j];
                            elements[j] = elements[i];
                            elements[i] = temp;
                        }
                    }
                }
                
                int res = 0;
                for (int i = 0; i < elements.length; i++) {
                    res = getNumberOfCoins(target, i);
                    if (res != 0) {
                        break;
                    }
                }
                
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int getNumberOfCoins(int target, int startIndex) {
        int count = 0;
        if (startIndex > elements.length) {
            return count;
        }
        if (target >= elements[startIndex] && elements[startIndex] != 0) {
            count = target / elements[startIndex];
            int cover = elements[startIndex] * count;
            int due = target - cover;
            if (due != 0) {
                int res = 0;
                for (int i = startIndex + 1; i < elements.length; i++) {
                    res = getNumberOfCoins(due, i);
                    if (res != 0) {
                        break;
                    }
                }
                if (res == 0) {
                    count -= target / elements[startIndex];
                } else {
                    count += res;
                }
            } else {
                return count;
            }
        }
        return count;
    }
}

