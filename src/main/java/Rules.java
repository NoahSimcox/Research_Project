import java.util.ArrayList;

public class Rules {

    public static boolean letter(RNA_sequence seq, Nucleotide pair_one, Nucleotide pair_two) {

        if ((seq.nucleotide_type(pair_one) == 'a' && seq.nucleotide_type(pair_two) == 'u')
                || (seq.nucleotide_type(pair_one) == 'u' && seq.nucleotide_type(pair_two) == 'a')) {
            return true;
        }

        else if ((seq.nucleotide_type(pair_one) == 'g' && seq.nucleotide_type(pair_two) == 'c')
                || (seq.nucleotide_type(pair_one) == 'c' && seq.nucleotide_type(pair_two) == 'g')) {
            return true;
        }
        return false;
    }

    public static boolean adjacent(Nucleotide pair_one, Nucleotide pair_two) {
        if (Math.abs(pair_one.index - pair_two.index) > 1) {
            return true;
        }
        return false;
    }

    public static boolean crossing(Pair pair_one, Pair pair_two) {

        return
                ((pair_one.get_nucleotide_north().index < pair_two.get_nucleotide_north().index
                        && pair_one.get_nucleotide_south().index > pair_two.get_nucleotide_south().index)

                        || (pair_one.get_nucleotide_south().index < pair_two.get_nucleotide_south().index
                        && pair_one.get_nucleotide_south().index < pair_two.get_nucleotide_north().index)

                        || (pair_one.get_nucleotide_north().index > pair_two.get_nucleotide_north().index
                        && pair_one.get_nucleotide_south().index < pair_two.get_nucleotide_south().index));

    }

}