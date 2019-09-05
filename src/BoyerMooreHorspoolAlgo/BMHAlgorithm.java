package BoyerMooreHorspoolAlgo;

import java.util.Hashtable;

class
BMHAlgorithm {

    private int cost = 0;
    private Hashtable<Character, Integer> charCosts = new Hashtable<>();
    private char chrDefault = '*';

    private void initialize(){
        this.cost = 0;
        this.charCosts.clear();
    }


    String printCost(String sentence, String word){
        int comparison = word.length() - 1, step = word.length() - 1;

        char[] sentenceChars = sentence.toLowerCase().toCharArray(), wordChars = word.toLowerCase().toCharArray();
        setCharCosts(word);

        while (comparison != 0 && step < sentenceChars.length){

            if (sentenceChars[step] != wordChars[comparison]){

                if (!charCosts.containsKey(sentenceChars[step])) step += this.charCosts.get(chrDefault);
                else step += this.charCosts.get(sentenceChars[step]);

                comparison = word.length() - 1;
            }
            else{
                step--;
                comparison--;
            }

            this.cost++;
        }

        this.cost++;

        if (comparison == 0){
            return "Le coût de la recherche est de " + cost + ".";
        }
        else if (step >= sentenceChars.length){
            return "Le mot n'a pas été trouvé.";
        }
        else{
            return "Il y a eu un problème.";
        }
    }

    private void setCharCosts(String word){
        this.initialize();

        for (int i = 0; i < word.length(); i++){
            if (i == (word.length() - 1)) this.charCosts.put(word.charAt(i), word.length());
            else this.charCosts.put(word.charAt(i), ( word.length() - i - 1));
        }

        this.charCosts.remove(word.charAt(word.length() - 1));
        this.charCosts.put(chrDefault, word.length());
    }
}
