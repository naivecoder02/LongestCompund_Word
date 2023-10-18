import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LongestCompoundWord {

    public static void main(String[] args) throws FileNotFoundException {
        processFile("Input_01.txt");
        processFile("Input_02.txt");
    }

    public static void processFile(String filename) throws FileNotFoundException {
        long startTime = System.currentTimeMillis(); // Record the start time

        File file = new File(filename);
        Trie trie = new Trie();
        LinkedList<Pair<String>> queue = new LinkedList<Pair<String>>();
        HashSet<String> compoundWords = new HashSet<String>();

        Scanner sc = new Scanner(file);

        String word;
        List<Integer> startidx;

        while (sc.hasNext()) {
            word = sc.next();
            startidx = trie.getSuffixesStartIndices(word);

            for (int i : startidx) {
                if (i >= word.length())
                    break;
                queue.add(new Pair<String>(word, word.substring(i)));
            }

            trie.insert(word);
        }

        Pair<String> p;
        int maxLength = 0;
        String longest = "";
        String sec_longest = "";

        while (!queue.isEmpty()) {
            p = queue.removeFirst();
            word = p.second();
            startidx = trie.getSuffixesStartIndices(word);

            if (startidx.isEmpty()) {
                continue;
            }

            for (int i : startidx) {
                if (i > word.length()) {
                    break;
                }   

                if (i == word.length()) {
                    if (p.first().length() > maxLength) {
                        sec_longest = longest;
                        maxLength = p.first().length();
                        longest = p.first();
                    }

                    compoundWords.add(p.first());
                } else {
                    queue.add(new Pair<String>(p.first(), word.substring(i)));
                }
            }
        }

        long endTime = System.currentTimeMillis(); 
        long executionTime = endTime - startTime; 


        System.out.println("File: " + filename);
        System.out.println("Longest Compound Word: " + longest);
        System.out.println("Second Longest Compound Word: " + sec_longest);
        System.out.println("Time taken to process file "+filename+" : "+ executionTime + " milliseconds");
        System.out.println();
    }
}
