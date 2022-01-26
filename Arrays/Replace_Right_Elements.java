class Replace_Right_Elements {
    public static int[] replaceElements(int[] arr) {
        int oldMax = -1;
        int newMax;
        
        for(int i = arr.length - 1; i >= 0; i--){
            newMax = Math.max(oldMax, arr[i]);
            arr[i] = oldMax;
            oldMax = newMax;
        }
        
        return arr;
        
    }
}