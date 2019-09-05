import java.util.Hashtable;

class BMHAlgorithm {

    private char[] sentenceChars; // sentence set in parameter transformed in chars array
    private int cost = 0; // search's cost
    private Hashtable<Character, Integer> charCosts = new Hashtable<>();


    void printCost(String sentence, String word){

        int comparison = word.length(), step = word.length();
        boolean found = false;

        while (!found){

            step = charCosts.get(sentenceChars[step]);

            if (comparison == 0){ // if the entire word matches in the sentence
                found = true;
            }

            this.cost++;
        }

        this.sentenceChars = sentence.toCharArray();

        setCharCosts(word);

        System.out.println(this.charCosts);
    }

    private void setCharCosts(String word){

        for (int i = 0; i < word.length(); i++){
            if (i == (word.length() - 1)) charCosts.put(word.charAt(i), word.length());
            else charCosts.put(word.charAt(i), ( word.length() - i - 1));
        }

        charCosts.remove(word.charAt(word.length() - 1));
        charCosts.put('*', word.length());

    }

}
