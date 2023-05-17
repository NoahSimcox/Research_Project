import graphics.graphics.Line;

import java.util.Scanner;
import java.util.ArrayList;


class Main {
    public static ArrayList<String[]> strings = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter RNA sequence:");
        String RNA_input = scan.nextLine();

        RNA_sequence RNA = new RNA_sequence(RNA_input);

        System.out.println(RNA);

        Array initialSeq = new Array();
        Array2 library = new Array2();

        for (int i = 0; i < RNA.size() - 1; i++){
            Nucleotide pair_one = new Nucleotide(i);
            for (int j = i + 1; j < RNA.size(); j++){
                Nucleotide pair_two = new Nucleotide(j);
                if (Pair.pair(RNA, pair_one, pair_two) == true){
                    Pair match = new Pair(pair_one, pair_two);
                    initialSeq.add_pair(match);

                }

            }

        }
        System.out.println(initialSeq.toString());

        library.add_row();
        int count = 0;
        for (int a = 0; a < initialSeq.size()-1; a++){
            for (int b = a + 1; b < initialSeq.size(); b++){
                if (Rules.crossing(initialSeq.get(a), initialSeq.get(b))){
                    library.add_pairList(new ArrayList<Pair>());
                    library.get(0).get(count).add(initialSeq.get(a));
                    library.get(0).get(count).add(initialSeq.get(b));
                    count++;
                }


            }

        }


        library.add_row();
        for (int a = 0; a < library.get(library.size()-2).size(); a++){
            count = 0;
            for (int e = 0; e < initialSeq.size(); e++){
                for (int b = 0; b < library.get(library.size()-2).size(); b++){
                    int count2 = 0;
                    for (int c = 0; c < library.get(library.size()-2).get(b).size(); c++){
                        if (Rules.crossing(library.get(library.size()-2).get(b).get(c), initialSeq.get(e))){
                            count2++;
                            if(count2 == library.get(library.size()-2).get(b).size()){
                                library.add_pairList(new ArrayList<Pair>());
                                library.get(library.size()-1).get(count).add(initialSeq.get(e));

                                for (int d = 0; d < library.get(library.size()-2).get(b).size(); d++){
                                    library.get(library.size()-1).get(count).add(library.get(library.size()-2).get(b).get(d));}

                                if (library.get(library.size()-1).size() > 1){
                                    for (int f = 0; f < library.get(library.size()-1).size()-1; f++){

                                        if (Repeat.isRepeat(library.get(library.size()-1).get(library.get(library.size()-1).size()-1), library.get(library.size()-1).get(f))){
                                            library.get(library.size()-1).remove(library.get(library.size()-1).get(library.get(library.size()-1).size()-1));
                                            count--;
                                        }


                                    }
                                }
                                count++;
                            }
                        }


                    }
                }
            }
            library.add_row();
        }
        int sum = 0;
        for (int num = 0; num < library.size(); num++){

            sum += library.get(num).size();
        }

        System.out.println(library.toString());

        System.out.println("Total possibilities = "+ (1 + sum + initialSeq.size()));



        System.out.println("Enter a fold possibility:");
        int lattice = scan.nextInt();

        Display display;

        if (lattice <= initialSeq.size()) {

            display = new Display(initialSeq.get(lattice - 1), RNA);

            for (int h = 0; h < display.getLineArray().size(); h++) {

                display.getLineArray().get(h).draw();
            }
        }


        else {

            int pairCount = 0;

        search: {
            for (int y = 0; y < library.size(); y++) {
                for (int z = 0; z < library.get(y).size(); z++) {

                    if (lattice == pairCount) {
                        display = new Display(library.get(y).get(z), RNA);

                        for (int h = 0; h < display.getLineArray().size(); h++) {

                            display.getLineArray().get(h).draw();
                        }

                        break search;
                        }

                    pairCount++;
                    }
                }
            }
        }
    }
}







