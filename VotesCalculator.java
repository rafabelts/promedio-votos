import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class VotesCalculator {
    private int candidateId;
    private final Scanner scanner = new Scanner(System.in);
    private Map<Integer, Integer> totalVotes = new HashMap<>();


    VotesCalculator(int candidateId) {
        this.candidateId = candidateId;
    }

    void insertCandidate(Map<Integer, String> candidates) {
        System.out.println("Ingresa el nombre del candidato:");
        String name = scanner.nextLine();

        candidates.put(this.candidateId, name);
        this.candidateId++;
    }

    void insertVote(Map<Integer, String> candidates, ArrayList<Integer> votes){
        //     ArrayList<Integer> candidatesArr = new ArrayList<>(); // storage the candidates id's

        System.out.println("Ingresa el numero del candidato: ");
        for (Map.Entry<Integer, String> entry : candidates.entrySet()) {
            //           candidatesArr.add(entry.getKey());
            System.out.printf("%d. %s\n", entry.getKey(), entry.getValue());
        }

        // Arrays.asList(givenArrayOfStrings).contains(yourString)
        int vote = scanner.nextInt();

        /*if(!candidatesArr.contains(vote)) {

        }*/

        votes.add(vote);
    }

    void calculateVotes(Map<Integer, String> candidates, ArrayList<Integer> votes){
        float votesSize = votes.size();

        for (Map.Entry<Integer, String> entry : candidates.entrySet()) {
            this.totalVotes.put(entry.getKey(), 0);
        }

        for (int vote:votes) {
            this.totalVotes.put(vote, this.totalVotes.get(vote) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : this.totalVotes.entrySet()) {
            System.out.printf("Cantidato %d: %d votos\n", entry.getKey(), entry.getValue());
            System.out.printf("Promedio de votos para el candidato %d: %f\n", entry.getKey(), (entry.getValue() / votesSize) * 100);
        }
    }
}