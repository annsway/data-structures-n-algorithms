import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter a string: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in),1);
        String s = input.readLine();

        System.out.println("Reversed string: "+ reverse(s));

    }

    private static String reverse(String s) {

        if (s.length()<=1){
            return s;
        }

        String revStr = s.substring(1, s.length()-1);
        return s.charAt(s.length()-1)+reverse(revStr)+s.charAt(0);

    }

}

