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
    private char[] doubleLetters;
    private char[] tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;

    // getters
    public String getWord() {
        return this.word;
    }

    // main
    public static void main(String[] args) {

    }

    // constructors
    public Scrabble(String word) {
        this.word = word;
    }

    public Scrabble(String word, char[] doubleLetters, char[] tripleLetters, boolean doubleWord, boolean tripleWord){
        this.word = word;
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
    }

    // methods
    public int score() {
        String word = this.getWord();
        int score = 0;
        if (word != null) {
            char[] charArr = word.toUpperCase().toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                score += letterScore(charArr[i]);
            }
        }
        return score;
    }

    public int letterScore(char letter) {
        int letterScore = 0;
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
                }
            }
        }
        return score;
    }



}
