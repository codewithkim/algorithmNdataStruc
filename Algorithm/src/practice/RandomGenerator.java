package practice;

import java.util.HashSet;
import java.util.Set;

public class RandomGenerator {

    // class variable
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//12345674890";

    final java.util.Random rand = new java.util.Random();

    // consider using a Map<String,Boolean> to say whether the identifier is being used or not 
    final Set<String> identifiers = new HashSet<String>();


    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        RandomGenerator obj = new RandomGenerator();

        System.out.println(obj.randomIdentifier());
        System.out.println(obj.randomIdentifier());
        System.out.println(obj.randomIdentifier());
        System.out.println(obj.randomIdentifier());
        System.out.println(obj.randomIdentifier());
    }
}
