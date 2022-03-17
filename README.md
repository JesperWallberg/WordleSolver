# WordleSolver - Java

Solve word games, like wordle. 

## How to use

Note: If you're using the english dictionary with wordle, some words may not be valid. 

* The game shows you a suggested list of words, and the number of possible words left in the dictionary.
* The user enters a word in the game they're playing. Enter the same word into WordleSolver.
* The game shows the result of the guess, enter the result in the program. (g = green, y = yellow, x = wrong). 
  * Example: BADGE | B = green, A = wrong, D = yellow, G = wrong, E = wrong | Entered word: BADGE | Result: GXYXX
* The program now suggests new words, and shows the number of words left.

## How it works

The program uses the dictionary to find the letter frequency of all the words. Then it tries to find words using the most frequent letters, these are suggested.

If a letter is black, every word containing this letter is removed. 
If a letter is yellow, every word without this letter in its position, or does not contain it, will be removed.
If a letter is green, every word not containing a letter in this position is removed. 

## Credit

For my dictionaries, I used these: 

* [@dwyl / english-words](https://github.com/dwyl/english-words)



