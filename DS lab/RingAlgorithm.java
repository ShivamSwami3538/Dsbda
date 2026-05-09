public class RingAlgorithm {

    public static void main(String[] args) {

        int processes[] = {1, 2, 3, 4, 5};
        int n = processes.length;

        int initiator = 2;
        int max = initiator;

        int currentIndex = initiator - 1;

        System.out.println("Election starts from Process " + initiator);

        for (int i = 0; i < n; i++) {

            int nextIndex = (currentIndex + 1) % n;
            int nextProcess = processes[nextIndex];

            System.out.println(processes[currentIndex] + " → " + nextProcess);

            if (nextProcess > max) {
                max = nextProcess;
            }

            currentIndex = nextIndex;
        }

        System.out.println("Leader is Process " + max);
    }
}
