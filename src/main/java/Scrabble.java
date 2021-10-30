import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Locale;
/*
A-Z (65 - 90)
{65, 69, 73, 79, 85, 76, 78, 82, 83, 84}
{68, 71}
{66, 67, 77, 80}
{70, 72, 86, 87, 89}
{75}
{74, 88}
{81, 90}
 */
public class Scrabble {
    final private static char[][] letterValues = {
            {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'},
            {'D', 'G'},
            {'B', 'C', 'M', 'P'},
            {'F', 'H', 'V', 'W', 'Y'},
            {'K'},
    };

    final private static char[][] letterValues2 = {
            {'J', 'X'},
            {'Q', 'Z'}
    };

    final private String word;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;

    private byte score = 0;
    private byte tempLetterScore = 0;

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
        if (this.word != null) {
            this.calculateScore();
            this.applyWordBonus();
        }
        return this.score;
    }

    public void calculateScore() {
        char[] charArr = this.word.toUpperCase().toCharArray();
        for (char letter : charArr) {
            letterScore(letter);
            this.score += this.tempLetterScore;
        }
    }

    public void letterScore(char letter) {
        computeLetterScore(letter);
        if (this.applyLetterBonus()) {
           computeLetterBonus(letter);
        }
    }

    public void computeLetterBonus(char letter) {
        if (applyCorrectLetterBonus(letter, this.doubleLetters)) {
            this.tempLetterScore *= 2;
        } else if (applyCorrectLetterBonus(letter, this.tripleLetters)) {
            this.tempLetterScore *= 3;
        }
    }

    public void computeLetterScore(char letter) {
        if (letter == 'J' || letter == 'X' || letter == 'Q' || letter == 'Z') {
            computeLetterValue(letter, letterValues2);
        } else {
            computeLetterValue(letter, letterValues);
        }
    }

    public void computeLetterValue(char letter, char[][] conversionTable) {
        for (byte i = 0; i < conversionTable.length; i++) {
            for (byte j = 0; j < conversionTable[i].length; j++) {
                applyCorrectConversion(letter, conversionTable, conversionTable[i][j], i);
            }
        }
    }

    public void applyCorrectConversion(char letter, char[][] conversionTable,
     char value, byte index) {
        if (letter == value && conversionTable == letterValues) {
            this.tempLetterScore = (byte) (index + 1);
        } else if (letter == value && conversionTable == letterValues2) {
            this.tempLetterScore = (byte) (2 * index + 8);
        }
    }

    public boolean applyLetterBonus() {
        return this.doubleLetters != null && this.tripleLetters != null;
    }

    public boolean applyCorrectLetterBonus(char letter,
                                           Character[] letterBonusArr) {
        for (byte i = 0; i < letterBonusArr.length; i++) {
            if (letter == letterBonusArr[i]) {
                letterBonusArr[i] = '\u0000';
                return true;
            }
        }
        return false;
    }

    public void applyWordBonus() {
        if (this.doubleWord) {
            this.score *= 2;
        } else if (this.tripleWord) {
            this.score *= 3;
        }
    }
}
