import java.util.HashMap;
import java.util.Set;

public class HashMapExample {

    public static void main (String[] args){

        HashMap<String, String> gradeMap = new HashMap<>();
        gradeMap.put("Ann", "A");
        gradeMap.put("Bob", "B");
        gradeMap.put("Collin", "C");

        // put the keys of a map to a set
        Set<String> keys = gradeMap.keySet();

        for(String key:keys){
            System.out.println(key + "'s grade is "+gradeMap.get(key));
        }


    }

}
