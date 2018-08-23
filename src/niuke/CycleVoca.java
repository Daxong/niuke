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

        for (int i = 0 ; i < vocabularys.length ; i++) {
            String str = in.nextLine();
            if (str.length() >= 1 & str.length() <= 50) {
                vocabularys[i] = str;
            }else{
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

            for (int n = 0 ; n < vocabularys.length ; n++) {
                if (count.contains(i)){
                    continue;
                }
                if (ss.contains(vocabularys[n])) {
                    set.add(i);
                    set.add(n);
                    map.put(ss,set);
                }
            }
            count.addAll(set);
        }

        System.out.print(map.size());


    }
}
