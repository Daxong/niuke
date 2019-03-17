package JavaProperties;

public class Main2{
    static long count = 0;
    public static void main(String[] args) {
        opt(0,0,5,5);
        System.out.println(count);
    }

    public static void opt(int i, int j, int x, int y) {
        count++;
        if(i < x && j < y ) {
            //走法加1
            opt(i,++j,x,y);
            opt(++i,j,x,y);
        }

        if(i < x && j >= y) {

            opt(++i,j,x,y);
        }

        if(i >= x && j < y ) {

            opt(i,++j,x,y);

        }

    }
}