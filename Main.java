import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Wordle wordle = new Wordle();

        while(!wordle.solved && wordle.lives>0)
        {
            //cheat
            //System.out.println(wordle.word);

            System.out.println("Make a guess: ");
            System.out.println();
            String guess = scanner.nextLine();
            wordle.makeGuess(guess);
        }

        if(!wordle.solved)
        {
            System.out.println("You failed! The word was : " + wordle.word + ". Rerun the program and try again.");
        }
        else
        {
            System.out.println("You Guessed It!");
        }



    }
}
