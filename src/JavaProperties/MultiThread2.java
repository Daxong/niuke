package JavaProperties;

public class MultiThread2 {
    static StringBuffer stringBuffer = new StringBuffer("aaa");
    static class T1 extends Thread{
        @Override
        public void run(){
            stringBuffer.append("_A");
        }
    }

    static class T2 extends Thread{
        @Override
        public void run(){
            stringBuffer.append("_B");
        }
    }

    static class T3 extends Thread{
        @Override
        public void run(){
            stringBuffer.append("_C");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        Thread t3 = new T3();
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(stringBuffer);
        }

    }
}
