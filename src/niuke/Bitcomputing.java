package niuke;

public class Bitcomputing {
    static int add(int x, int y) {
        if (y == 0) {
            return x;
        }
        int sum = x ^ y;
        int carry = (x & y) << 1 ;
        return add(sum,carry);
    }

    public static void main(String[] args) {
        int res = add(2,3);
        System.out.println(res);
    }
}
