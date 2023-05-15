import java.util.ArrayList;

public class Pair
{
    private Nucleotide north;
    private Nucleotide south;

    public Pair(Nucleotide north, Nucleotide south){
        this.north = north;
        this.south = south;
    }

    public Nucleotide get_nucleotide_north(){
        return north;
    }
    public Nucleotide get_nucleotide_south(){
        return south;
    }

    public static boolean pair(RNA_sequence seq, Nucleotide pair_one, Nucleotide pair_two){

        if (Rules.adjacent(pair_one, pair_two)){
            if (Rules.letter(seq, pair_one, pair_two)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return (north.toString()+" "+south.toString());
    }

}