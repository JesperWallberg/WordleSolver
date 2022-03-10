import java.io.IOException;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary("dictionaries/english.txt");
        Stats stat = new Stats();
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 6; i++){
            String word, result;

            stat.printWords(dic);
            stat.suggestedWords(dic);
            stat.printNumberOfWords(dic);

            System.out.print("Entered word: ");
                word = scan.nextLine();
            System.out.print("Result: ");
                result = scan.nextLine();

            dic.removeWords(word, result);
        }

    }
}
