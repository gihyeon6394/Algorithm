import lib.StdIn;
import lib.StdOut;
import lib.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        String champion = "";
        int i = 1;

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();

            if (StdRandom.bernoulli(1.0 / i)) {
                champion = word;
            }

            i++;
            StdOut.println("ㅋㅋㅋ: "+champion);

        }

        StdOut.println(champion);
    }
}
