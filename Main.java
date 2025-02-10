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
                case 1:
                    calculator.insertCandidate(candidates);
                    break;
                case 2:
                    calculator.insertVote(candidates, votes);
                    break;
                case 3:
                    System.out.println();
                    calculator.calculateVotes(candidates, votes);
                    System.out.println();
                    System.out.println("Desea salir del programa? (Ingresa el numero de la accion)\n1. Si\n2. No");
                    if (scanner.nextInt() == 1) isRunning = false;
                    else continue;
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        }
    }

}
