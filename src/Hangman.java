/*
 the main class
 */

import acm.program.*;


public class Hangman extends ConsoleProgram {
    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
    }

    public void run() {
        // getting the word and setting variables
        word = lexicon.getWord();
        String guess = getGuess();
        String lastGuess;
        int count = word.length() + 3;
        println("Welcome to Hangman");

        //getting user input
        while (!word.equalsIgnoreCase(guess.toLowerCase()) && count > 0) {
            println("the word now looks like this: " + guess);
            println("you have " + count + " tries");
            String character = readLine("your guess: ");

            // checking if the user imput is only one letter
            while (character.length() != 1) {
                println("write only one letter");
                character = readLine("your guess: ");
            }
            //checking if the word contains users input
            lastGuess = guess;
            guess = checkCharacter(guess, character);
            if (lastGuess.equalsIgnoreCase(guess)) count--;
        }

        // checking if user wins or not
        if (count == 0) {
            println("you loose the word was " + word.toLowerCase());
        } else {
            println("you won the word was " + guess);
        }

    }

    //changing word to guess
    private String getGuess() {
        String retWord = "";
        for (int i = 0; i < word.length(); i++) {
            retWord += "-";
        }
        return retWord;
    }

    // checking character
    private String checkCharacter(String guessedWord, String character) {
        if (guessedWord.contains(character.toLowerCase())) {
            return  guessedWord;
        } else if (!word.toLowerCase().contains(character.toLowerCase())) {
            return guessedWord;
        }
        for (int i = 0; i < word.length(); i ++) {
            if (word.toLowerCase().charAt(i) == character.toLowerCase().charAt(0)) {
                String left = guessedWord.substring(0,i);
                String right = guessedWord.substring(i + 1);
                guessedWord = left + character.toLowerCase() + right;
            }
        }
        return guessedWord;

    }

    // instance variables
    private HangmanLexicon lexicon = new HangmanLexicon();
    private HangmanCanvas canvas;
    private String word;
}
