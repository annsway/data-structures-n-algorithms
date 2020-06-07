import java.util.HashMap;
import java.util.Set;

public class HashMapExample {

    public static void main (String[] args){

        // Keys and values in a HashMap are actually objects.
        // To use other types, such as int, you must specify an equivalent wrapper class: Integer. 
        // For other primitive types, use: Boolean for boolean, Character for char, Double for double
        HashMap<String, Integer> gradeMap = new HashMap<>();

        // add elements to hash map 
        gradeMap.put("Ann", 100);
        gradeMap.put("Bob", 99);
        gradeMap.put("Collin", 89);

        // put the keys of a map to a set
        Set<String> keys = gradeMap.keySet();

        // loop through a hash map 
        for(String key:keys){
            System.out.println(key + "'s grade is "+gradeMap.get(key));
        }

        // or
        for(String i:gradeMap.keySet()){
            System.out.println("key: " + i + ", value: "+gradeMap.get(i));
        }

        // access an item 
        gradeMap.get("Ann");

        // remove an item 
        gradeMap.remove("Bob");

        // HashMap size
        System.out.println("The size of the grade Hash Map is "+gradeMap.size());

    }

}
