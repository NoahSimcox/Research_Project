import java.util.ArrayList;

public class Array {
    private ArrayList<Pair> seq;

    public Array() {
        seq = new ArrayList<Pair>();
    }

    public void add_pair(Pair pair){
        seq.add(pair);
    }

    public int size(){
        return seq.size();
    }

    public Pair get(int index){
        return seq.get(index);
    }

    public String toString() {
        return seq.toString();
    }

}
