import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int k = 100000;
        int n = 50;
        long t0r, t1r, t0a, t1a;

        int[] sequence = new int[k];
        Random rnd = new Random();

        System.out.println("# Linked vs doubly linked with reference");
        System.out.printf("#%7s\t%9s\t%9s\t%9s\t%9s\n", "n", "Remove linked", "Add linked", "Remove doubly",
                "Add doubly");


        System.out.printf("%8d\t", n);

        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n);
        }
        DoubleLinkedList[] allDoubles = new DoubleLinkedList[n];
        LinkedList[] allSingles = new LinkedList[n];


        DoubleLinkedList firstDouble = new DoubleLinkedList(0, null, null);
        allDoubles[0] = firstDouble;

        for (int i = 1; i < n; i++) {
            DoubleLinkedList newDouble = new DoubleLinkedList(i, null, null);
            firstDouble.append(newDouble);
            allDoubles[i] = newDouble;
        }

        LinkedList firstSingle = new LinkedList(0, null);
        allSingles[0] = firstSingle;

        for (int i = 1; i < n; i++) {
            LinkedList newSingle = new LinkedList(i, null);
            firstSingle.append(newSingle);
            allSingles[i] = newSingle;
        }

        t1r = 0;
        t1a = 0;

        for (int i = 0; i < k; i++) {
            t0r = System.nanoTime();
            firstSingle = firstSingle.remove(allSingles[sequence[i]]);
            t1r += (System.nanoTime() - t0r);
            t0a = System.nanoTime();
            firstSingle.append(allSingles[sequence[i]]);
            t1a += (System.nanoTime() - t0a);
        }
        System.out.printf("%9.0f\t", ((double)t1r / k));
        System.out.printf("%9.0f\t", ((double)t1a / k));

        t1r = 0;
        t1a = 0;

        for (int i = 0; i < k; i++) {
            t0r = System.nanoTime();
            firstDouble = firstDouble.removeObject(allDoubles[sequence[i]]);
            t1r += (System.nanoTime() - t0r);
            t0a = System.nanoTime();
            firstDouble.append(allDoubles[sequence[i]]);
            t1a += (System.nanoTime() - t0a);
        }


        System.out.printf("%9.0f\t", ((double)t1r / k));
        System.out.printf("%9.0f\t\n", ((double)t1a / k));

        //System.out.println(n + "        " + (tsr1 / k) + "                " + (tsa1 / k) + "                " + (tdr1 / k) + "                " + (tda1 / k));

        //System.out.println(td1 + " För Double Linked list");

        //System.out.println(n + "        " + (tsr1 / k) + "                " + (tsa1 / k) + "                " + (tdr1 / k) + "                " + (tda1 / k));

    }


}
