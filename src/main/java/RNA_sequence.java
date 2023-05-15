import java.util.ArrayList;

public class RNA_sequence {

    private ArrayList<Character> RNA;

    public RNA_sequence(String seq) {
        RNA = new ArrayList<Character>();

        for (int i = 0; i < seq.length(); i++) {
            RNA.add(seq.charAt(i));
        }

    }

    public char nucleotide_type(Nucleotide n) {
        return RNA.get(n.index);
    }

    public int size() {
        return RNA.size();
    }


    public String toString() {
        return RNA.toString();
    }
}
