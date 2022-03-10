import java.io.*;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<String> words = new ArrayList<>();

    Dictionary(String lang) throws IOException {
        reader(lang);
    }

    public void reader(String lang) throws IOException {
        File fileName = new File(lang);

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        for(String read = reader.readLine(); read != null; read = reader.readLine()){
            words.add(read);
        }
    }

    public ArrayList<String> getWords(){
        return this.words;
    }

    public void removeWords(String word, String result){
        for(int j = 0; j < words.size(); j++){
            for(int i = 0; i < 5; i++){
                if(result.charAt(i) == 'y'){
                    yellow(word.charAt(i), i);
                }else if(result.charAt(i) == 'g'){
                    green(word.charAt(i), i);
                }else if(result.charAt(i) == 'x'){
                    black(word.charAt(i));
                }
            }
        }
    }

    public void yellow(char letter, int position){
        for(int i = 0; i < words.size(); i++){
            if(!(words.get(i).contains(String.valueOf(letter))) || words.get(i).charAt(position) == letter){
                words.remove(i);
            }
        }
    }

    public void green(char letter, int position){
        for(int i = 0; i < words.size(); i++){
            if(!(words.get(i).charAt(position) == letter)){
                words.remove(i);
            }
        }
    }

    public void black(char letter){
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).contains(String.valueOf(letter))){
                words.remove(i);
            }
        }
    }
}
