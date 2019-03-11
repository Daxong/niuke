package THUCode;

public class Number2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int length = 5;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            ++count;
            for (int j = i; j < 10; j++) {
//                ++count;
//                if (length == 2) {
//                    System.out.println(i+""+j);
//                }else{
                    for (int n = j; n < 10; n++){
//                        ++count;
//                        if (length == 3) {
//                            System.out.println(i+""+j+""+n);
//                        }else{
                            for (int k = n; k < 10; k++) {
//                                ++count;
//                                if (length == 4) {
//                                    System.out.println(i+""+j+""+n+""+k);
//                                }else {
                                    for (int m = k; m < 10; m++){
//                                        ++count;
                                        System.out.println(i+""+j+""+n+""+k+""+m);
                                    }
//                                }

                            }
//                        }

                    }
//                }

            }
        }
        long yu = System.currentTimeMillis() - start;
        System.out.println("for:"+yu);
//        System.out.println(count);
        long ma = printNum(100000);
        if (ma > yu) {
            System.out.println("ma大"+ma+"yu小"+yu);
        } else {
            System.out.println("yu大"+yu+"ma小"+ma);
        }
    }

    public static long printNum(int num) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < num+1; i++) {
            int a = 9, b = 9;
            boolean flag = true;
            int digit = i;
            while (num / 10 == 0) {
                a = num % 10;
                if (a > b) {
                    flag = false;
                    break;
                }
                b = a;
                num = num / 10;

            }
            if (flag) {
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis() - start;
        return end;
    }

}
