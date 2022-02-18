class ParityCheck{
    public static short parityCheck(long x){
        short parityBit = 0;
        while(x != 0){
            parityBit ^= ( x & 1 );
            x >>>= 1;
        }
        return parityBit;
    }

    public static void main(String[] args){
        long bigNumber = 1073741824; // 2^30 = 1 Gig. Parity is 1.
        System.out.println("The Parity of Big Number " + bigNumber + " (2^30 or 1 Gigabyte) is: " + parityCheck(bigNumber));
    }
}