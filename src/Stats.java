import java.util.Collections;

public class Stats {
    char letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    int letterCount[] = new int[26];

    public int numberOfWords(Dictionary dictionary){
        return dictionary.getWords().size();
    }

    public void letterFreq(Dictionary dictionary){
        for(int i = 0; i < numberOfWords(dictionary); i++){
            for(int j = 0; j < 5; j++){
                for(int h = 0; h < letterCount.length; h++){
                    if(dictionary.getWords().get(i).charAt(j) == letters[h]){
                        letterCount[h]++;
                    }
                }
            }
        }
    }

    public void sortLetterFreq(){
        for(int i = 0; i < letterCount.length - 1; i++){
            for(int j = 0; j < letterCount.length - i - 1; j++){
                if(letterCount[j] < letterCount[j + 1]){
                    int temp = letterCount[j];
                    char tempChar = letters[j];

                    letterCount[j] = letterCount[j + 1];
                    letters[j] = letters[j + 1];

                    letterCount[j + 1] = temp;
                    letters[j + 1] = tempChar;
                }
            }
        }
    }

    public void suggestedWords(Dictionary dictionary){
        int[] wordScore = new int[numberOfWords(dictionary)];

        sortLetterFreq();

        for(int i = 0; i < numberOfWords(dictionary); i++){
            String letterUsed = "";

            for(int j = 0; j < 5; j++){
                for(int h = 0; h < 26; h++){
                    if(dictionary.getWords().get(i).charAt(j) == letters[h]){
                        if(!letterUsed.contains(String.valueOf(letters[h]))){
                            wordScore[i] += (letterCount.length - h);
                            letterUsed += letters[h];
                        }
                    }
                }
            }
        }

        sortSuggestions(dictionary, wordScore);
    }

    public void sortSuggestions(Dictionary dictionary, int[] wordScore){
        for(int i = 0; i < wordScore.length - 1; i++){
            for(int j = 0; j < wordScore.length - i - 1; j++){
                if(wordScore[j] < wordScore[j + 1]){
                    Collections.swap(dictionary.getWords(), j, j+ 1);

                    int temp = wordScore[j];
                    wordScore[j] = wordScore[j + 1];
                    wordScore[j + 1] = temp;
                }
            }
        }

        System.out.println("Best suggestions: ");
        for(int i = dictionary.getWords().size() - 1; i > 0; i--){
            System.out.println(dictionary.getWords().get(i));
        }
    }

    public void printNumberOfWords(Dictionary dictionary){
        System.out.println("Number of words left: " + numberOfWords(dictionary));
    }

    public void printWords(Dictionary dictionary){
        System.out.println("Words that can be used: ");

        for(int i = 0; i < numberOfWords(dictionary); i++){
            System.out.println(dictionary.getWords().get(i));
        }
    }

    public void printLetterFreq(){
        System.out.println("Letter freq: ");

        for(int i = 0; i < letterCount.length; i++){
            System.out.println(letters[i] + ": " + letterCount[i]);
        }
    }
}
