/**
 * Take Village people to temple to other side of river with a boat of two persons with minimum cost.
 * e.g. villagePeople = {3, 6, 7, 12 , 19, 23} // where every element is the man with fare price for travelling on boat.
 * NOTE: Boat cannot come empty.
 */
import java.util.*;

class VillageTempleProblem {
	public static void main( String... args){
		
        List<Integer> villagePeople = new LinkedList<>(Arrays.asList(1, 7, 6, 7, 10, 50, 25));

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
                de.pollLast();
                sum += FirstPerson + SecondPerson + currentPerson;
                System.out.println(FirstPerson + " + " + SecondPerson + "+" + currentPerson);
                if (!de.isEmpty()) {
                    System.out.println(" + " + SecondPerson);
                    sum += SecondPerson;
                }
            }

            System.out.println("Cost of People Travelling is : " + sum);
        }
    
	}
}
