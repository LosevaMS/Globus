package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String [] args) {
        startGame();
    }

    private static void startGame() {
        Scanner in = new Scanner(System.in);
        byte tries = 15;
        String word = getWord();
        System.out.println(word);
        ArrayList<Character> knownLetters = new ArrayList<>();
        do {
            printTries(tries);
            printGameState(word, knownLetters);
            String answer = in.nextLine();
            if (isStringOnlyAlphabet(answer) && (answer.length() == word.length() || answer.length() == 1 )) {
                if(answer.length() == 1) {
                    if(word.contains(answer)) {
                        knownLetters.add(answer.charAt(0));
                    }
                } else {
                    if (wordsAreEqual(answer, word)) {
                        for (int i = 0; i < answer.length(); i++) {
                            if(!knownLetters.contains(answer.charAt(i))) {
                                knownLetters.add((answer.charAt(i)));
                            } // i love u nastya <3
                        }
                    }
                }
            } else {
                System.out.println("Wrong answer: answer must contain only latin letters\nYou may write 1 letter or a whole word");
            }

        } while (--tries > 0 && !isWin(knownLetters, word));
        endGame(isWin(knownLetters, word), word);
    }

    private static boolean wordsAreEqual(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (!isLettersEqual(a.charAt(i), b.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean isWin(ArrayList<Character> knownLetters, String word){
        for (int i = 0; i < word.length(); i++) {
            if (!knownLetters.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void endGame(boolean isWin, String word)
    {
        if (isWin) System.out.println("Congratulations! The word was " + word);
        else System.out.println("Try next time. The word was " + word);
    }

    private static boolean isLettersEqual(char a, char b) {
        if (a == b) return true;
        else return Math.max(a, b) == Math.min(a, b) + 32;
    }

    private static boolean isStringOnlyAlphabet(String str) {
        return (str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$"));
    }

    private static void printTries(byte tries)
    {
        System.out.print("\n\nYou have " + tries  + " tries!");
    }

    private static void printGameState(String word, ArrayList<Character> knownLetters) {
        boolean letterExists;
        System.out.print("\nThere is " + word.length() + " letters in the word:\t");
        if (knownLetters.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                System.out.print(" _");
            }
        }
        else {
            for (int i = 0; i < word.length(); i++) {
                letterExists = false;
                System.out.print(' ');
                for (int elem : knownLetters) {
                    if (elem == word.charAt(i)) {
                        System.out.print(word.charAt(i));
                        letterExists = true;
                    }
                }
                if (!letterExists) {
                    System.out.print('_');
                }
            }
        }
        System.out.print("\nPrint a letter or write the word: ");
    }

    private static String getWord() {
        Random random = new Random();
        String[] words = {"friends", "lol", "customer", "employee", "banana"};
        return words[random.nextInt(words.length)];
    }
}