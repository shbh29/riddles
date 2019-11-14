/**
 * Take Village people to temple to other side of river with a boat of two persons with minimum cost.
 * e.g. villagePeople = {3, 6, 7, 12 , 19, 23} // where every element is the man with fare price for travelling on boat.
 * NOTE: Boat cannot come empty.
 */
import java.util.*;
import java.io.*;

class VillageTempleProblem {
	public static void main( String... args) throws Exception{
		
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		
		System.out.println("Please Enter Number of Elements(Press 0 for taking default list)");

		int totalNumberOfProducts = 0;
		totalNumberOfProducts = Integer.parseInt(br.readLine());
        	List<Integer> villagePeople;
	        if(totalNumberOfProducts==0){
			villagePeople	= new LinkedList<>(Arrays.asList(1, 7, 6, 7, 10, 50, 25));
		} else {
			villagePeople = new LinkedList<Integer>();
		}
		for(int i = 0; i < totalNumberOfProducts; i++) {
			System.out.print("\n Person "+(i+1)+": ");
			villagePeople.add(Integer.parseInt(br.readLine()));
		}

		System.out.println("List is : "+villagePeople.toString());
		

        Collections.sort(villagePeople);
        Deque<Integer> de = new LinkedList(villagePeople);
        int sum = 0;
        if (de.size() > 2) {
            Integer FirstPerson = de.pollFirst();
            Integer SecondPerson = de.pollFirst();

            while (!de.isEmpty()) {
                int currentPerson = de.removeLast();
                /**
                 * Removed Second Last Element. As Only Last element needed to
                 * add in sum.
                 */
                Integer hiddenPerson = de.pollLast();
		hiddenPerson = hiddenPerson == null ? FirstPerson : hiddenPerson;

                //sum += FirstPerson + SecondPerson + currentPerson;
                System.out.println(" + " + SecondPerson + "("+SecondPerson+", "+FirstPerson+") = " + (sum+=SecondPerson));
                System.out.println(" + " + FirstPerson + "( , "+FirstPerson+")  = " + (sum+=FirstPerson));
                System.out.println(" + " + currentPerson + "("+currentPerson+", "+hiddenPerson+")  = " + (sum+=currentPerson));
                if (!de.isEmpty()) {
                	System.out.println(" + " + SecondPerson + "( , "+SecondPerson+")   = " + (sum+=SecondPerson));
                 //   sum += SecondPerson;
                }
            }

            System.out.println("Cost of People Travelling is : " + sum);
        }
    
	}
}
