import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {

    ArrayList<String> words = new ArrayList<>();
    String word;
    ArrayList<String> answer = new ArrayList<>();

    Boolean solved = false;
    int lives = 6;

    public Wordle()
    {
        pickWords();
        pickRandomWord();
        answer = toArrayList(word);
    }

    public void makeGuess(String gues)
    {
        //System.out.println(word);
        gues = gues.toUpperCase();
        if(gues.length() != 5)
            System.out.println("Please guess a 5 letter word");
        else if(!words.contains(gues))
        {
            System.out.println("Please guess an actual word");
        }
        else
        {
            if(gues.equals(word))
            {
                solved = true;

            }

            ArrayList<String> guess = toArrayList(gues);


            for (int i=0; i<5; i++)
            {
                if(guess.get(i).equals(answer.get(i))) //green letters
                {
                    System.out.print("\033[48:5:10m" + guess.get(i));
                    answer.set(i, "1");
                }
                else if(answer.contains(guess.get(i)))//yellow letters
                {
                    System.out.print("\033[48:5:11m" + guess.get(i));
                    answer.set(answer.indexOf(guess.get(i)), "1");
                }
                else//red letters
                {
                    System.out.print("\033[48:5:9m" + guess.get(i));
                }

            }



            System.out.println("\033[48:5:0m");
            answer = toArrayList(word);
            System.out.println();


            lives--;
            if(!solved)
            {
                System.out.println("You have " + lives + " chances left");
            }

        }
    }

    public void show()
    {

    }

    public ArrayList<String> toArrayList(String s)
    {
        ArrayList<String> ans = new ArrayList<>();
        for (int i=0; i<s.length(); i++)
        {
            ans.add(s.substring(i,i+1));
        }
        return ans;
    }

    private void pickRandomWord()
    {
        int index = (int) (Math.random()*words.size());
        word = words.get(index);
    }
    private void pickWords() {
        try {
            File file = new File("C:\\Users\\micke\\IdeaProjects\\Wordle\\src\\words.txt");
            Scanner scanner = new Scanner(file);
            int i = 0;
            //represents how many words are in words.txt
            int MAX_WORDS = 45402;
            String line = "";
            while (i < MAX_WORDS) {
                line = scanner.next();
                if(line.length() == 5)
                {
                    words.add(line.toUpperCase());
                }
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
