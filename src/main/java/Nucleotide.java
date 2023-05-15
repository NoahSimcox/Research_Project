public class Nucleotide {
    public final int index;

    public Nucleotide(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null)
            return false;

        if (this == other)
            return true;

        if (getClass() != other.getClass())
            return false;

        Nucleotide otherN = (Nucleotide) other;

        if (index != otherN.index)
            return false;

        return true;
    }

    public String toString(){
        return (""+index);
    }
}
