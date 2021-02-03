/*
 the main class
 */

import acm.program.*;

import java.util.Locale;

public class Hangman extends ConsoleProgram{
    public void run() {
        word = lexicon.getWord();
        String guess = getGuess();
        int count = word.length() + 3;
        println("Welcome to Hangman");

        while (!word.toLowerCase().equals(guess.toLowerCase()) && count > 0) {
            println("the word now looks like this: " + guess);
            println("you have " + count + " tries");
            String character = readLine("your guess: ");
            while (character.length() != 1) {
                println("write only one letter");
                character = readLine("your guess: ");
            }
            guess = checkCharacter(guess, character);
            count --;
        }
        if (count == 0) {
            println("you loose the word was " + word.toLowerCase());
        } else {
            println("you won the word was " + guess);
        }

    }

    private String getGuess() {
        String retWord = "";
        for (int i = 0; i < word.length(); i++) {
            retWord += "-";
        }
        return retWord;
    }

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
    private String word;
}
