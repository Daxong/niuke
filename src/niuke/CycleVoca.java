package niuke;
import java.util.*;

public class CycleVoca {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        String[] vocabularys = null;
        if (row <= 50 & row >= 1){
            vocabularys = new String[row];
        }else{
            return;
        }
//        in.nextLine();
        for (int i = 0 ; i < vocabularys.length ; i++) {

            String str = in.next();

            if (str.length() >= 1 & str.length() <= 50) {
                vocabularys[i] = str;
            }else{
                return;
            }
            if (str.matches("/^[A-Z]/g")) {
                return;
            }
        }
        Map map = new HashMap<String,HashSet<Integer>>();
        Set count = new HashSet<Integer>();
        for (int i = 0 ; i < vocabularys.length ; i++) {
            if (count.contains(i)){
                continue;
            }
            String ss = vocabularys[i]+vocabularys[i];
            Set set = new HashSet<Integer>();
            int flag = 0;
            for (int n = i ; n < vocabularys.length ; n++) {
                if (count.contains(i)){
                    continue;
                }
                if (n+1 < vocabularys.length) {
                    if (ss.contains(vocabularys[n+1])) {
                        flag = 1;
                        set.add(i);
                        set.add(n);
                        map.put(ss,set);
                    }
                }

            }

            if (flag == 1) {
                count.addAll(set);
            }

        }

        System.out.print(map.size());


    }
}
