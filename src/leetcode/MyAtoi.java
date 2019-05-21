package leetcode;

public class MyAtoi {

    public int myAtoi(String str) {
        boolean num = str.trim().matches("-?\\d+");
        if (num) {
            System.out.println(str.trim().matches("^-?\\d+$"));

        }
        return 0;
    }

    public static void main(String[] args) {
        new MyAtoi().myAtoi(" -234 str");
    }
}
