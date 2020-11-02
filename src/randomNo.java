import java.util.*;

public class randomNo {

    public static void main(String args[]){

        HashSet<Integer> ramdomSet=generateRandomNumbers(500);
        int nth_Number=50;
        System.out.println("nth smallest number = "+findKthSmallest(ramdomSet, nth_Number));

        //Below code is just to test the result, and not part of implementation
        List<Integer> sortList = new ArrayList<Integer>(ramdomSet);
        Collections.sort(sortList);
        System.out.println("From sort,nth smallest number = "+sortList.get(nth_Number-1));

    }

    public static int findKthSmallest(HashSet<Integer> ramdomSet, int n) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); 

        for(int value: ramdomSet){
            maxHeap.add(value);
            if(maxHeap.size()>n) 
                maxHeap.remove();
        }
        return maxHeap.remove();
    }

    public static HashSet<Integer> generateRandomNumbers(int numberLimit) {
    	
        Random random = new Random();
        HashSet<Integer>  ramdonSet = new HashSet<>();

        while (ramdonSet.size() <=  numberLimit){
            ramdonSet.add(random.nextInt()); //set is used to avoid duplicates
        }
        return ramdonSet;
    }

}