
class BitCount {
    public static short countBits(int x){
        short numBits = 0;
        while(x != 0){
            numBits += (x & 1);
            x >>>= 1;
        }

        return numBits;
    }

    public static void main(String[] args) {
        int num = 8; // Binary rep 1000 -> Only 1 "1" Bit.
        System.out.println("The Number of 1's in the Binary Rep of " + num + " is: " + countBits(num));
    }
}