public class Scrabble {
    char[][] letterValues = {
            {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'},
            {'D', 'G'},
            {'B', 'C', 'M', 'P'},
            {'F', 'H', 'V', 'W', 'Y'},
            {'K'},
    };
    int[] index = {0, 1, 2, 3, 4};
    int[] values = {1, 2, 3, 4, 5};
    char[][] letterValues2 = {
            {'J', 'X'},
            {'Q', 'Z'}
    };
    int[] index2 = {0, 1};
    int[] values2 = {8, 10};

    private String word;

    public static void main(String[] args) {

    }

    public String getWord() {
        return this.word;
    }

    public Scrabble(String word) {
        this.word = word;
    }

    public int score() {
        String word = this.getWord();

        int score = 0;
        if (word != null) {
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                for (int j = 0; j < letterValues.length; j++) {
                    for (int k = 0; k < letterValues[j].length; k++) {
                        if (letterValues[j][k] == charArr[i]) {
                            score += j + 1;
                        }
                    }
                }
            }
        }
        return score;
    }


}
