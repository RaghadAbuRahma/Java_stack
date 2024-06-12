import java.util.Random;
public class puzzleTest{
    public static void main(String[] args){
        PuzzleJava puzzle = new PuzzleJava();
        // int[] test = new int[10];
        int[] test = puzzle.getTenRolls();

        for (int i=0; i<test.length; i++ ){
            System.out.print(test[i] + " ");
        }

        // System.out.println(puzzle.getTenRolls());




}
}
