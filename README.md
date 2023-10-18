# LongestCompund_Word

# Description
The "Longest Compound Word Finder" is a Java program that processes a list of words from input files to identify the longest and second longest compound words. A compound word is a word that can be constructed by concatenating shorter words found in the same list. The program utilizes a Trie data structure to efficiently search for compound words.

# Approach
The program follows these steps to identify compound words:
Read words from an input file, one word per line.
Utilize a Trie data structure to store the words and their substrings efficiently.
Process each word to find all of its suffixes and add them to a queue for further examination.
While processing the queue, check if the current word is a compound word by searching the Trie.
Keep track of the longest and second longest compound words found.
Measure the time taken to process the input file.

# Key Functions

**Trie.java:**

**->insert(String s):** Inserts a word into the Trie data structure.

**->getSuffixesStartIndices(String s):** Returns a list of starting indices for all the suffixes of a given word.

**Pair.java:**

**->Pair:** A simple class used to store pairs of two objects.This class is used to store pairs of words and their substrings during the processing of words in the main program.

**LongestCompoundWord.java:**

**->processFile(String filename):** Processes an input file to find the longest and second longest compound words, as well as the time taken to process the file.

**->main(String[] args):** The main entry point of the program. Calls processFile for two input files, "Input_01.txt" and "Input_02.txt."

# Execution:

Compile the Java source code files.

Run the LongestCompoundWord program.

Check that the input files, "Input_01.txt" and "Input_02.txt" are present in the same repository.

The program will display the results separately for each input file, including the longest and second longest compound words and the time taken to process each file.
