import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Locale;

public class Scrabble {
    /*int[] index = {0, 1, 2, 3, 4};
    int[] values = {1, 2, 3, 4, 5};*/
    char[][] letterValues = {
            {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'},
            {'D', 'G'},
            {'B', 'C', 'M', 'P'},
            {'F', 'H', 'V', 'W', 'Y'},
            {'K'},
    };
    /*int[] index2 = {0, 1};
    int[] values2 = {8, 10};*/
    char[][] letterValues2 = {
            {'J', 'X'},
            {'Q', 'Z'}
    };

    private String word;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;

    private int tempLetterScore;

    // main
    public static void main(String[] args) {

    }

    // constructors
    public Scrabble(String word) {
        this.word = word;
    }

    public Scrabble(String word, Character[] doubleLetters,
                    Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
    }

    // methods
    public int score() {
        int score = 0;
        if (this.word != null) {
            char[] charArr = this.word.toUpperCase().toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                int letterScore = letterScore(charArr[i]);
                if (this.doubleLetters != null && this.tripleLetters != null) {
                    if (applyDoubleLetterBonus(charArr[i])) {
                        letterScore *= 2;
                    } else if (applyTripleLetterBonus(charArr[i])) {
                        letterScore *= 3;
                    }
                }
                score += letterScore;
            }
        }

        // apply bonus for double/triple words
        score = applyWordBonus(score);

        return score;
    }

    public int letterScore(char letter) {
        int letterScore;
        if (letter == 'J' || letter == 'X' || letter == 'Q' || letter == 'Z') {
            letterScore = highValLetterScore(letter);
        } else {
            letterScore = lowValLetterScore(letter);
        }
        return letterScore;
    }

    public int lowValLetterScore(char letter) {
        int score = 0;
        for (int i = 0; i < letterValues.length; i++) {
            for (int j = 0; j < letterValues[i].length; j++) {
                if (letter == letterValues[i][j]) {
                    score = i + 1;
                    break;
                }
            }
        }
        return score;
    }

    public int highValLetterScore(char letter) {
        int score = 0;
        for (int i = 0; i < letterValues2.length; i++) {
            for (int j = 0; j < letterValues2[i].length; j++) {
                if (letter == letterValues2[i][j]) {
                    score += 2 * i + 8;
                    break;
                }
            }
        }
        return score;
    }

    public int applyWordBonus(int score) {
        if (this.doubleWord) {
            score *= 2;
        } else if (this.tripleWord) {
            score *= 3;
        }
        return score;
    }

    public boolean applyDoubleLetterBonus(char letter) {
        for (int i = 0; i < this.doubleLetters.length; i++) {
            if (letter == this.doubleLetters[i]) {
                this.doubleLetters[i] = '\u0000';
                return true;
            }
        }
        return false;
    }

    public boolean applyTripleLetterBonus(char letter) {
        for (int i = 0; i < this.tripleLetters.length; i++) {
            if (letter == this.tripleLetters[i]) {
                this.tripleLetters[i] = '\u0000';
                return true;
            }
        }
        return false;
    }



}
