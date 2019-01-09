package niuke;

public class Overload {
    public static void say(char... arg){
        System.out.println("char...");
    }

    public static void main(String[] args) {
        say('s','s');
    }
}
