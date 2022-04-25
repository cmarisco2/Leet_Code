import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortKeys{


    public static void main(String[] args){
        String[] codes = {"def123", "abc999", "zzz000", "abc123", "zzz111"};

        System.out.println("Pre-sorted product codes:");
        System.out.println(Arrays.toString(codes));
        System.out.println();
        
        //* use substring for prefix in the comparator
        Comparator<String> prefixCmp = new Comparator<String>() {
            public int compare(String s1, String s2){
                return s1.substring(0,3).compareTo(s2.substring(0,3));
            }
        };
        Comparator<String> suffixCmp = (s1, s2) -> { return s1.substring(3).compareTo(s2.substring(3));};

        // * sort suffix only.
        Arrays.sort(codes, suffixCmp);
        System.out.println("Sorted by suffixes");
        System.out.println(Arrays.toString(codes));
        System.out.println();
        //* sort prefixes only:
        Arrays.sort(codes, prefixCmp);
        System.out.println("Sorted by prefixes");
        System.out.println(Arrays.toString(codes));
        System.out.println();
        
    }
}