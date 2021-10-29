import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Locale;

public class Scrabble {
    /*int[] index = {0, 1, 2, 3, 4};
    int[] values = {1, 2, 3, 4, 5};*/
    final private static char[][] letterValues = {
            {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'},
            {'D', 'G'},
            {'B', 'C', 'M', 'P'},
            {'F', 'H', 'V', 'W', 'Y'},
            {'K'},
    };
    /*int[] index2 = {0, 1};
    int[] values2 = {8, 10};*/
    final private static char[][] letterValues2 = {
            {'J', 'X'},
            {'Q', 'Z'}
    };

    final private String word;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;

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
    public byte score() {
        byte score = 0;
        if (this.word != null) {
            char[] charArr = this.word.toUpperCase().toCharArray();
            for (char letter : charArr) {
                byte letterScore = letterScore2(letter);
                score += letterScore;
            }
            score = applyWordBonus(score);
        }
        return score;
    }

    public byte letterScore2(char letter) {
        byte letterScore = letterScore(letter);
        if (this.doubleLetters != null && this.tripleLetters != null) {
            if (applyDoubleLetterBonus(letter)) {
                letterScore *= 2;
            } else if (applyTripleLetterBonus(letter)) {
                letterScore *= 3;
            }
        }
        return letterScore;
    }

    public byte letterScore(char letter) {
        byte letterScore;
        if (letter == 'J' || letter == 'X' || letter == 'Q' || letter == 'Z') {
            letterScore = calculateLetterValue(letter, letterValues2);
        } else {
            letterScore = calculateLetterValue(letter, letterValues);
        }
        return letterScore;
    }

    public byte calculateLetterValue(char letter, char[][] conversionTable) {
        byte score = 0;
        for (byte i = 0; i < conversionTable.length; i++) {
            for (byte j = 0; j < conversionTable[i].length; j++) {
                if (letter == conversionTable[i][j]) {
                    if (conversionTable == letterValues) {
                        score = (byte) (i + 1);
                    } else {
                        score = (byte) (2 * i + 8);
                    }
                }
            }
        }
        return score;
    }

    public byte applyWordBonus(byte score) {
        if (this.doubleWord) {
            score *= 2;
        } else if (this.tripleWord) {
            score *= 3;
        }
        return score;
    }

    public boolean applyDoubleLetterBonus(char letter) {
        for (byte i = 0; i < this.doubleLetters.length; i++) {
            if (letter == this.doubleLetters[i]) {
                this.doubleLetters[i] = '\u0000';
                return true;
            }
        }
        return false;
    }

    public boolean applyTripleLetterBonus(char letter) {
        for (byte i = 0; i < this.tripleLetters.length; i++) {
            if (letter == this.tripleLetters[i]) {
                this.tripleLetters[i] = '\u0000';
                return true;
            }
        }
        return false;
    }
}
