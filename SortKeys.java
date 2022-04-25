import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortKeys{

    public static boolean isLetter(char ch){
        return ch >= 97  && ch <= 122;
    }

    public static void main(String[] args){
        // String[] codes = {"def123", "abc999", "zzz000", "abc123", "zzz111"};
        String[] codes = {"azf-9121", "aaz-0215", "abc-jabr", "acd-aloy"};
        // List<String> letters = Arrays.asList(codes);
        List<String> letters = new LinkedList<>();
        for(String s : codes){
            if(isLetter(s.charAt(4))) letters.add(s);
        }
        System.out.println("Pre-sorted product codes:");
        System.out.println(Arrays.toString(codes));
        System.out.println();

        List<String> notLetters = new LinkedList<>();

        for(String s : codes){
            if(!isLetter(s.charAt(4))) {
                notLetters.add(s);
            }
        }
        
        Comparator<String> letterCmp = new Comparator<String>(){
             public int compare(String s1, String s2){
                 String x1 = s1.substring(3);
                 String x2 = s2.substring(3);
                 return x1.compareTo(x2);
             }
         };

         for(String s : letters){
             System.out.print(s + " ");
         }
         System.out.println();
         for(String s : notLetters){
             System.out.print(s + " ");
         }
         System.out.println();
         letters.sort(letterCmp);
         List<String> total = new LinkedList<>();
         for(String s : letters){
            total.add(s);
         }
         for(String s: notLetters){
             total.add(s);
         }
         System.out.println("Total sorted List: ");
         for(String s : total){
             System.out.print(s + " ");
         }
         System.out.println();
        //  Arrays.sort(codes, letterCmp);
        //  System.out.println("Sorted Codes: ");
        //  System.out.println(Arrays.toString(codes));
        
    }
}