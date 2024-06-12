import java.util.Random;

class PuzzleJava {
    public int[] getTenRolls() {
        Random randMachine = new Random();

        int[] myArray;
        myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = randMachine.nextInt(0, 21);
        }
        return myArray;

    }

}