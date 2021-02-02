/*
 the main class
 */

import acm.program.*;

public class Hangman extends ConsoleProgram{
    public void run() {
        word = lexicon.getWord();
        String guess = getGuess();

        while (!word.equals(guess)) {
            println("Welcome to Hangman");
            println("the word now looks like this: " + guess);
            String character = readLine("your guess: ");
            while (character.length() != 1) {
                character = readLine("your guess: ");

            }
            guess = checkCharacter(guess, character);
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
        if (guessedWord.contains(character)) {
            return  guessedWord;
        } else if (!word.contains(character)) {
            return guessedWord;
        }
        for (int i = 0; i < word.length(); i ++) {
            if (word.charAt(i) == character.charAt(0)) {
                String left = guessedWord.substring(0,i);
                String right = guessedWord.substring(i + 1, guessedWord.length());
                guessedWord = left + character + right;
            }
        }
        return guessedWord;

    }

    // instance variables
    private HangmanLexicon lexicon = new HangmanLexicon();
    private String word;
}
