import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SeatAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int partyQuantity = sc.nextInt();
        int seats = sc.nextInt();

        int[] counts = new int[partyQuantity];

        PriorityQueue<Map.Entry<Integer, Double>> parties = new PriorityQueue<>(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < partyQuantity; i++) {
            double partyVotes = sc.nextInt();
            parties.offer(Map.entry(i, partyVotes));
        }
        for (int i = 0; i < seats; i++) {
            Map.Entry<Integer, Double> partyWithVotes = parties.poll();
            int party = partyWithVotes.getKey();
            counts[party] += 1;
            double votes = partyWithVotes.getValue() * counts[party];

            parties.offer(Map.entry(party, votes / (counts[party] + 1)));
        }

        for (int count : counts) {
            System.out.println(count);
        }

        sc.close();

    }

}
