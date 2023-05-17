import graphics.graphics.Line;

import java.util.ArrayList;

public class Display {

    private Line line;

    private final int startX = 200;

    private final int startY = 400;

    private int endX;

    private int endY;

    private ArrayList<String> seqArray;

    private ArrayList<Line> lineArray;

    public Display(Pair pair, RNA_sequence seq){

        seqArray = new ArrayList<>();

        for (int i = 0; i < seq.size(); i++){

            if (pair.get_nucleotide_north().index == i)
                seqArray.add("n");
            else if (pair.get_nucleotide_south().index == i)
                seqArray.add("s");
            else
                seqArray.add(null);
        }


        for (int j = 0; j < seqArray.size(); j++){

            if (seqArray.get(0) == null) {
                line = new Line(startX, startY, endX += (startX + 100), endY += startY);
                lineArray.add(line);
            } else{

                line = new Line(startX, startY, endX += startX, endY += (startY - 100));
                lineArray.add(line);
            }


            if (j != 0 && seqArray.get(j) == null){

                line = new Line(endX, endY, endX += 100, endY);
                lineArray.add(line);
            } else if (j != 0 && seqArray.get(j).equals("n")) {

                line = new Line(endX, endY, endX, endY -= 100);
                lineArray.add(line);
            } else if (j != 0 && seqArray.get(j).equals("s")) {

                line = new Line(endX, endY, endX, endY += 100);
                lineArray.add(line);
            }


        }

    }

    public Display(ArrayList<Pair> pairArray, RNA_sequence seq) {

        seqArray = new ArrayList<>();

        for (int i = 0; i < seq.size(); i++) {
            for (int j = 0; j < pairArray.size(); j++) {

                if (pairArray.get(j).get_nucleotide_north().index == i)
                    seqArray.add("n");
                else if (pairArray.get(j).get_nucleotide_south().index == i)
                    seqArray.add("s");

            }

            if (!(seqArray.get(i).equals("n") || seqArray.get(i).equals("s")))
                seqArray.add(null);
        }

        for (int k = 0; k < seqArray.size(); k++){

            if (seqArray.get(0) == null) {
                line = new Line(startX, startY, endX += (startX + 100), endY += startY);
                lineArray.add(line);
            } else{

                line = new Line(startX, startY, endX += startX, endY += (startY - 100));
                lineArray.add(line);
            }


            if (k != 0 && seqArray.get(k) == null){

                line = new Line(endX, endY, endX += 100, endY);
                lineArray.add(line);
            } else if (k != 0 && seqArray.get(k).equals("n")) {

                line = new Line(endX, endY, endX, endY -= 100);
                lineArray.add(line);
            } else if (k != 0 && seqArray.get(k).equals("s")) {

                line = new Line(endX, endY, endX, endY += 100);
                lineArray.add(line);
            }


        }
    }

    public ArrayList<Line> getLineArray(){

        return lineArray;
    }

}
