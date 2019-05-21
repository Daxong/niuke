package leetcode;

public class Enumber {
    public static void main(String[] args) {
        printEncrypt(100);
    }

    public static void printEncrypt(int n){
        String[] str = new String[]{"Fizz","Buzz","Fizzbuzz"};
        for (int i = 1; i < n+1; i++) {
            if (i % 15 == 0) {
                System.out.println(str[2]);
            }else if (i % 5 == 0) {
                System.out.println(str[1]);
            }else if (i % 3 == 0) {
                System.out.println(str[0]);
            }else {
                System.out.println(i);
            }
        }
    }
}
