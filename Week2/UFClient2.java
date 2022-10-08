import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int index = 0;
        boolean check = true;

        while (!StdIn.isEmpty()) {
            check = true;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!(uf.find(p) == uf.find(q))) {
                uf.union(p, q);
                StdOut.println(p + " and " + q);
            }
            index++;
            for (int i = 1; i < N; i++) {
                if (!(uf.find(i) == uf.find(0))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(index);
                break;
            }
        }

        if (!check) {
            System.out.println("FAILED");
        }
    }
}

//javac -cp .;F:\LIB\Coursera\algs4.jar UFClient2.java
//java -cp .;F:\LIB\Coursera\algs4.jar UFClient2 < F:\LIB\Coursera\algs4-data\tinyUF.txt
