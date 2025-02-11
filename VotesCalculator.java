import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class VotesCalculator {
    private int candidateId;
    private final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, Integer> totalVotes = new HashMap<>();


    VotesCalculator(int candidateId) {
        this.candidateId = candidateId;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    void insertCandidate(Map<Integer, String> candidates) {
        while(true) {
            System.out.println("Ingresa el nombre del candidato:");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                System.out.println("Por favor, ingresa el nombre del candidato");
                continue;
            }

            if (isNumeric(name)) {
                System.out.println("No se permiten números como nombre de candidato.");
                continue;
            }

            candidates.put(this.candidateId, name);
            break;
        }


        this.candidateId++;
    }

    void insertVote(Map<Integer, String> candidates, ArrayList<Integer> votes){
        if(candidates.isEmpty()) {
            System.out.println("No se han agregado candidatos");
            return;
        }

        while (true) {
            System.out.println("Ingresa el número del candidato: ");

            for (Map.Entry<Integer, String> entry : candidates.entrySet()) {
                System.out.printf("%d. %s\t", entry.getKey(), entry.getValue());
            }
            System.out.println();

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("No ingresaste nada, intenta de nuevo.");
                continue;
            }

            try {
                int vote = Integer.parseInt(input);

                if (!candidates.containsKey(vote)) {
                 System.out.println("Por favor, ingresa un candidato valido");
                 continue;
                }

                votes.add(vote);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingresa un número válido.");
            }
        }
    }

    void calculateVotes(Map<Integer, String> candidates, ArrayList<Integer> votes){
        if(votes.isEmpty()){
            System.out.println("No se han agregado votos");
            return;
        }

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