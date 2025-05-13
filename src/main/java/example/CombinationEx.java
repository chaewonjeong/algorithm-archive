package example;

import java.util.ArrayList;

public class CombinationEx {
    private static ArrayList<String> resultList = new ArrayList<String>();

    public static void combinations(int idx, char[] order, String result){

        if(result.length() > 0){
            resultList.add(result);
        }

        for(int i = idx; i < order.length; i++){
            combinations(i+1, order, result+order[i]);
        }
    }
}
