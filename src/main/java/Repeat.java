import java.util.ArrayList;

public class Repeat {

    public static boolean isRepeat(ArrayList<Pair> seq, ArrayList<Pair> seq2) {

        int count = 0;
        for (int i = 0; i < seq.size(); i++) {
            for (int j = 0; j < seq2.size(); j++) {

                if (pairRepeat(seq.get(i), seq2.get(j)))
                    count++;
                if (count == seq.size())
                    return true;

            }

        }
        return false;
    }

    public static boolean pairRepeat(Pair pair, Pair pair2) {

        if (pair.get_nucleotide_north().index == pair2.get_nucleotide_north().index && pair.get_nucleotide_south().index == pair2.get_nucleotide_south().index) {

            return true;
        }

        return false;
    }
}

