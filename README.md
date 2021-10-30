## Instructions

1. Fork this repository and clone your forked repository:
2. Run the tests from IntelliJ. You can run your test suite in a few ways:
    1. Right-click on the project and then select `Run all Tests`
    2. Right-click on the `ScrabbleTest` and click `Run ScrabbleTest`
    3. Open the`ScrabbleTest`  class file and click the "Play" button to the 
       left of the class declaration

## My approach

My approach was to compute the value for each letter and check if 
letter bonuses need to be applied. Then I applied word bonuses at the very end.

I used nested arrays to create a conversion table for letters of the alphabet.
I made two separate arrays: one for letters with low values, and the other 
for letters with high values. I realised half-way through that a single array 
would have probably been easier, but I wanted to test this solution.
Then I used loops to iterate through the arrays, applying basic 
arithmetic to calculate the correct values for each letter.
Lastly, I created functions that would deal with letter bonuses and word 
bonuses.

## Domain Model

| Object | Property | Method | Output |
| ----------- | ----------- |----------- |----------- |
| Scrabble | `word@String` |score | `@byte` |
| | `doubleLetter@char[]` |checkIfNotNull | `@void`|
| | `tripleLetter@char[]` |setCharArr | `@void` |
| | `doubleWord@Boolean` |calculateScore | `@void`|
| | `tripleWord@Boolean` |letterScore  | `@void`|
| |`letterValues@char[][]`|computeLetterScore | `@void` |
| | `letterValues2@char[][]`|computeLetterValue | `@void` |
| | `score@byte`|applyCorrectConversion | `@void` |
| | `tempLetterScore@byte`|applyLetterBonus | `@boolean` |
| | `charArr@char[]`|computeLetterBonus | `@void` |
| | |applyCorrectLetterBonus | `@boolean` |
| | |applyWordBonus | `@void` |



















