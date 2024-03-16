import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       FileReader reader = new FileReader("input.txt");
       Scanner scanner = new Scanner(reader);
       StringBuilder data = new StringBuilder();
       while(scanner.hasNextLine()) {
           data.append(scanner.nextLine());
       }
       reader.close();
       ArrayList<String> fruits = new ArrayList<>(List.of(data.toString().split(" ")));
       fruits.removeIf(String::isEmpty);
       System.out.println("\nКол-во слов в файле: "+fruits.size());

        HashMap<String,Integer> frequencyOfFruits = new HashMap<String, Integer>();
        int maxWordLength=0;
        ArrayList<String> LongestWord=new ArrayList<>();
        for(String fruit : fruits) {
            if(frequencyOfFruits.containsKey(fruit)){
                int fruitQuantity = frequencyOfFruits.get(fruit);
                frequencyOfFruits.put(fruit, fruitQuantity+1);
            }
            else{
                frequencyOfFruits.put(fruit, 1);
                if(fruit.length()>maxWordLength){
                    LongestWord.clear();
                    maxWordLength=fruit.length();
                    LongestWord.add(fruit);
                }
                else if(fruit.length()==maxWordLength){
                    LongestWord.add(fruit);
                }

            }
        }
        System.out.println("\nСамое длинное слово: " + LongestWord);
        System.out.println("\nЧастота слов в файле:");
        for(String key: frequencyOfFruits.keySet()){
            Integer value = frequencyOfFruits.get(key);
            System.out.println("Слово: " + key+", Кол-во: " + value);
        }
    }

}