import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int initialID = 0;
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> candidates = new HashMap<>();
        ArrayList<Integer> votes = new ArrayList<>();
        VotesCalculator calculator = new VotesCalculator(initialID);

        while(isRunning) {
            System.out.println("Recuerda ingresar el numero de la accion a realizar\n1. Añadir candidato\n2. Añadir voto\n3. Calcular votos\n4. Salir");
            int accion = scanner.nextInt();
            switch (accion) {
                case 1 -> {
                    System.out.println();
                    calculator.insertCandidate(candidates);
                    System.out.println();
                }

                case 2 -> {
                    System.out.println();
                    calculator.insertVote(candidates, votes);
                    System.out.println();
                }

                case 3 -> {
                    System.out.println();
                    calculator.calculateVotes(candidates, votes);
                    System.out.println();
                }

                case 4 -> isRunning = false;

                default -> System.out.println("Opcion no valida");

            }
        }
    }

}
