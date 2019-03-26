package JavaProperties;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiThread {
    static StringBuffer stringBuffer ;
    static int count = 1;

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String str = scan.nextLine();
        stringBuffer = new StringBuffer(str);
        CyclicBarrier barrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                if (count == 0)
                System.out.println(stringBuffer);
            }
        });
        Thread t1 = new Thread(new T1(barrier));
        Thread t2 = new Thread(new T2(barrier));
        Thread t3 = new Thread(new T3(barrier));
        t1.start();
        t2.start();
        t3.start();
    }

    static class T1 implements Runnable{
        private CyclicBarrier barrier;
        public T1(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                stringBuffer.append("_A");
//                count--;
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class T2 implements Runnable{
        private CyclicBarrier barrier;
        public T2(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run(){
            try {
                stringBuffer.append("_B");
//                count--;
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    static class T3 implements Runnable{
        private CyclicBarrier barrier;
        public T3(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run(){
            try {
                stringBuffer.append("_C");
                count--;
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
