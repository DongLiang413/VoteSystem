import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * A class to generate random CSV files for OPL and IR files.
 */
public class RandomCSV {
    public static int count = 0;

    /**
     * Write a random OPL CSV file given a string of candidate names, seat count, and ballot count.
     * @param filename The filename to write the new file to.
     * @param candidates The String of Candidates. It is in the format specified in the example files.
     * @param candidateCount The number of Candidates.
     * @param seatCount The number of seats to be won.
     * @param ballotCount The number of ballots.
     */
    public static void writeRandomOPL(String filename, String candidates, int candidateCount, int seatCount,
                                      int ballotCount) {
        Random r = new Random();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(filename)));
        }
        catch (Exception e) {
            System.out.println("Error writing OPL CSV file ");
        }

        try {

            bw.write("OPL\n");
            bw.flush();
            bw.write(candidateCount+ "\n");
            bw.flush();
            bw.write(candidates + "\n");
            bw.flush();
            bw.write(seatCount+"\n");
            bw.flush();
            bw.write(ballotCount+"\n");
            bw.flush();
            for(int i = 0; i<ballotCount; i++) {
                int winner = r.nextInt(candidateCount);
                String [] s = new String[candidateCount];
                Arrays.fill(s, ",");
                s[winner] = Integer.toString(1);
                String st = "";
                for(int j = 0;j<s.length;j++) {
                    st = st + s[j];
                }
                bw.write(st+"\n");
                bw.flush();

            }
        }
        catch (Exception e) {
            System.out.println("Whoopity fuchking doodoo");
        }
        try {
            bw.close();
        } catch(Exception e) { System.out.println("Wooo");}
    }

    /**
     * Write a random IR CSV file given a string of candidate names, and ballot count.
     * @param filename The filename to write the new file to.
     * @param candidates The String of Candidates. It is in the format specified in the example files.
     * @param candidateCount The number of Candidates.
     * @param ballotCount The number of ballots.
     */


    public static void writeRandomIR(String filename, String candidates, int candidateCount,
                                     int ballotCount) {
        Random r = new Random();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(filename)));
        }
        catch (Exception e) {
            System.out.println("Whoopity fuchking doo");
        }

        try {

            bw.write("IR\n");
            bw.flush();
            bw.write(candidateCount+ "\n");
            bw.flush();
            bw.write(candidates + "\n");
            bw.flush();
            bw.write(ballotCount+"\n");
            bw.flush();
            for(int i = 0; i<ballotCount; i++) {
                int numbersRanked = r.nextInt(candidateCount) +1;
                String [] s = new String[(candidateCount-1) + numbersRanked];
                Arrays.fill(s, ",");
                int [] candidatesChosen = r.ints(0,candidateCount).distinct().limit(numbersRanked).toArray();
                int [] ballotMark = new int[candidateCount];
                for(int c = 0; c<candidatesChosen.length;c++) {
                    ballotMark[candidatesChosen[c]] = c+1;
                }



                String st = "";
                for(int j = 0;j<ballotMark.length;j++) {
                    if (ballotMark[j] == 0) {
                        st = st + "";
                    }
                    if (ballotMark[j] != 0) {
                        st = st + ballotMark[j];
                    }
                    if(j!=ballotMark.length-1) {
                        st = st + ",";
                    }

                }

                bw.write(st+"\n");
                bw.flush();

            }
        }
        catch (IOException e) {
            System.out.println("Error writing file.");
        }

        try {
            bw.close();
        } catch(Exception e) { System.out.println("Error closing BufferedWriter");}
    }


    public static void main (String[]args) {

    }

}

