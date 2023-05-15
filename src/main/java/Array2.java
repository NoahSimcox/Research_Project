import java.util.ArrayList;

public class Array2 {
    private ArrayList<ArrayList<ArrayList<Pair>>> seq;

    public Array2() {
        seq = new ArrayList<ArrayList<ArrayList<Pair>>>();
    }

    public void add_pairList(ArrayList<Pair> pair){
        seq.get(seq.size()-1).add(pair);
    }

    public void add_row(){
        seq.add(new ArrayList<ArrayList<Pair>>());
    }

    public int size(){
        return seq.size();
    }

    public ArrayList<ArrayList<Pair>> get(int index){
        return seq.get(index);
    }

    public String toString() {
        return seq.toString();
    }

}