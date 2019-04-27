import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Marcin on 27.04.2019
 */
public class Client {

    private static final int minRange = 1;
    private static final int maxRange = 1000;

    private Client() {}
    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            System.out.println("Services listed in registry:");
            LoadBalancerInterface balancerStub = (LoadBalancerInterface) registry.lookup("LoadBalancer");
            for(String s : balancerStub.getRegisteredServers()) System.out.println(s);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Type solver name to use: ");
            String solverName = scanner.nextLine();

            // Looking up the registry for the remote object
            SolverInterface stub = (SolverInterface) registry.lookup(solverName);

            long seed = generateRandomIntIntRange(minRange, maxRange);
            ProblemInstance problemInstance = getRandomInstance(seed);
            // Calling the remote method using the obtained object
            Solution solution = stub.solve(problemInstance);

            System.out.println(solution.toString());

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static ProblemInstance getRandomInstance(long seed) {

        long problemSize = seed / 2;
        int capacity = (int) seed * 2 + 5;

        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= problemSize; i++) {
            items.add(new Item(i + 5, (i * 1.5 + seed) % seed));
        }

        return new ProblemInstance(capacity, items);
    }

    private static long generateRandomIntIntRange(int min, int max) {

        Random r = new Random();
        int l = r.nextInt((max - min) + 1) + min;

        return Long.valueOf(l);
    }
}