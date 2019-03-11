package THUCode;

import java.util.LinkedList;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();
//        printNum(num);
        int length = 2;
        StringBuilder res = new StringBuilder("1");
        new Number().nums(1,1,4,res);
//        new Number().bf();
    }

    public void nums(int i,int len, int length, StringBuilder res) {
        int j = i;
        for (; j < 10; j++) {

            if (len == length) {
                System.out.println(res.replace(len-1,length,j+""));
            }else {
                len++;
                nums(j,len,length,res.replace(len-1,len,j+""));
            }
        }
    }

    public void bf(){
        int length = 4;
        int num = 3423;
        for (int i = 0; i < 10; i++) {

            for (int j = i; j < 10; j++) {
                if (length == 2 ) {
                    System.out.println(i+""+j);
                }else{
                    for (int n = j; n < 10; n++){
                        if (length == 3) {
                            System.out.println(i+""+j+""+n);
                        }else{
                            for (int k = n; k < 10; k++) {
                                if (length == 4) {
                                    System.out.println(i+""+j+""+n+""+k);
                                }else {
                                    for (int m = k; m < 10; m++){
                                        System.out.println(i+""+j+""+n+""+k+""+m);
                                    }
                                }

                            }
                        }

                    }
                }

            }
        }
    }

}
