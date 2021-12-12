package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    private List<Character> result = new ArrayList<>();

    public List<Character> getUniqueChars(String text){
        if(text == null){
            throw new IllegalArgumentException("Text is null.");
        }
        char[] wordToChar = text.toCharArray();
        for(char actual : wordToChar){
                if(!isInclude(result,actual)){
                    result.add(actual);
                }

        }
        return result;
    }

    private boolean isInclude(List<Character> listToCheck, char c){
        boolean test = false;
        for(int i =0; i < listToCheck.size(); i++){
            if(listToCheck.get(i) == c){
                test = true;
            }
        }
       return test;
    }
}
