//? Problem 170: Data Structure Design - TwoSumIII
//? Difficulty: 'Easy'
//? Description:

// Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

// Implement the TwoSum class:

// TwoSum() Initializes the TwoSum object, with an empty array initially.
// void add(int number) Adds number to the data structure.
// boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.

//? Example:
// Input["TwoSum","add","add","add","find","find"][[],[1],[3],[5],[4],[7]]Output[null,null,null,null,true,false]

// Explanation TwoSum twoSum=new TwoSum();twoSum.add(1); // [] --> [1]
// twoSum.add(3); // [1] --> [1,3]
// twoSum.add(5); // [1,3] --> [1,3,5]
// twoSum.find(4); // 1 + 3 = 4, return true
// twoSum.find(7); // No two integers sum up to 7, return false

//? Solution Idea:
//* Utilize HashMap internal structure
    //* Counts freq on numbers added.

//* Checks membership of complement value when the boolean find(int value) is called



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TwoSumIII {
    private Map<Integer, Integer> frequencyMap;
    private List<Integer> uniqueVals;
    
    public TwoSumIII() {
        this.frequencyMap = new HashMap<>();
        uniqueVals = new ArrayList<>();
    }
    
    public void add(int number) {
        if(this.frequencyMap.containsKey(number)) this.frequencyMap.replace(number, this.frequencyMap.get(number) + 1);
        else{
            this.frequencyMap.put(number, 1);
            uniqueVals.add(number);
        } 
    }
    
    public boolean find(int value) {
        for (int val : uniqueVals) {
            int key = val;
            int comp = value - key;
            if (comp == key && this.frequencyMap.get(key) > 1)
                return true;
            if (comp != key && this.frequencyMap.containsKey(comp))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */