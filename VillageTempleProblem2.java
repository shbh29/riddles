/**
 * Take Village people to temple to other side of river with a boat of two persons with minimum cost.
 * e.g. villagePeople = {3, 6, 7, 12 , 19, 23} // where every element is the man with fare price for travelling on boat.
 * NOTE: Boat cannot come empty.
 * NOTE: NewApproach
 */
import java.util.*;
import java.io.*;

class VillageTempleProblem2 {
	public static void main(String ...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number of People in Village: ");
		Integer NoOfPeople = Integer.parseInt(br.readLine());
		List<Integer> people = new ArrayList<Integer>();

		for(int i = 0; i < NoOfPeople; i++) {
			System.out.print("Person "+(i+1)+": ");
			people.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(people);
		System.out.println("List is: "+people.toString());

		int sum = 0;
		int j = people.size() - 1;
		for(; j > 2; j-=2) {
			int FirstPersonMethod = people.get(0)*2 + people.get(j)
			       + people.get(j-1);
			int SecondPersonMethod = people.get(0) + people.get(1)*2 + people.get(j);
			//System.out.println("First Method: "+FirstPersonMethod+", SecondPersonMethod: "+SecondPersonMethod);
			sum += FirstPersonMethod < SecondPersonMethod ? FirstPersonMethod : SecondPersonMethod;
		}
		
		if (j == 2)  {
			sum += people.get(2) + people.get(0) + people.get(1);
		} else {
			sum += people.get(1);
		}
		System.out.println("Total cost of Travel is: "+sum);
	}
}

