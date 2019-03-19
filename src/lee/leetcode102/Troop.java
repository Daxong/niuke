package lee.leetcode102;

import java.util.Stack;

/**
 * 某大学开学进行军训队列训练，将学生从一开始按顺序依次编号，并排成一行横队，训练的规则如下：
 * 从头开始一至二报数，凡报到二的出列剩下的依次向前靠拢，再从头开始进行一至三报数，凡报到三的出列，剩下的依次向前靠拢，
 * 继续从头开始进行一至二报数。。。以后每次从头开始轮流进行一至二报数、一至三报数直到剩下的人数不超过三人为止。
 */
public class Troop {
    static int count = 0;
    static boolean isdelete = false;
    static Stack<Integer> stu = new Stack<>();
    public static void main(String[] args) {
        Troop troop = new Troop();
        int n = 20;
        troop.loop(n,true);
//        System.out.println(count);
        troop.calc(n,1,true);
        for (int i = n; i > 0 ; i--) {
            troop.calc(i,1,true);
            if (isdelete==false){
                stu.push(i);
            }
            isdelete = false;
        }

    }

    //计算需要循环的次数
    public  void loop(int n, boolean flag) {
        if (flag) {
            n = n - n/2;
            flag = !flag;
        }else {
            n = n - n/3;
            flag = !flag;
        }
        count++;
//        System.out.println("第" + count+"轮之后剩"+n+"数");
        if (n >= 3){
            loop(n, flag);
        }
    }
    //计算一个数多少轮报数之间是否被删除
    public  void calc(int n, int lun, boolean flag){
        if (flag) {
            if (n % 2 == 0) {
//                System.out.println("第" + lun +"轮之后被删除");
                isdelete = true;
            }
            n = n - n/2;
            flag = !flag;
        }else {
            if (n % 3 == 0) {
//                System.out.println("第" + lun+"轮之后被删除");
                isdelete = true;
            }
            n = n - n/3;
            flag = !flag;
        }
        lun++;
        if (lun < count){
            calc(n,lun,flag);
        }
//        System.out.println("第" + lun+"轮之后没有被删除");

    }
}
