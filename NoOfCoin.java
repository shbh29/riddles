
import java.util.*;
import java.lang.*;
import java.io.*;

public class NoOfCoin {
    static List<Integer> elements;
    static Integer minimumCount;

    public static void main(String[] args) {
        //code
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int noOfTestCase = Integer.parseInt(br.readLine());
            for (int testcount = 0; testcount < noOfTestCase; testcount++) {
                String[] inputArray = br.readLine().split(" ");
                int target = Integer.parseInt(inputArray[0]);
                int noOfEle = Integer.parseInt(inputArray[1]);
                elements = new ArrayList<Integer>();
                minimumCount = null;
                String[] elementString = br.readLine().split(" ");
                for (int i = 0; i < noOfEle; i++) {
                    Integer temp = Integer.parseInt(elementString[i]) > target ? 0 : Integer.parseInt(elementString[i]);
                    elements.add(temp);
                }
                Collections.sort(elements, Collections.reverseOrder());
                
                getNumberOfCoins(target, 0, 0);
                
                System.out.println(minimumCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static int getNumberOfCoins(int target, int startIndex, int prevCount) {
        int count = 0;
        count = target / elements.get(startIndex);
        while (count >= 0 && (minimumCount == null || minimumCount > (prevCount + count))) {
            int cover = elements.get(startIndex) * count;
            int due = target - cover;
            if (due != 0) {
                for (int i = startIndex + 1; i < elements.size(); i++) {
                    if (due >= elements.get(i) && elements.get(i) != 0 && (minimumCount == null || minimumCount > (prevCount + count))) {
                        getNumberOfCoins(due, i, prevCount + count);
                    }
                }
                count--;
            } else {
                count += prevCount;
                if (minimumCount == null || minimumCount > count) {
                    minimumCount = count;
                }
                return count;
            }
        }
        return count;
    }
}


