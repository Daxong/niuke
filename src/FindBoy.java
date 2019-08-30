import java.util.Scanner;

/**
 * 在一圈人中找出被最多女生包围的男生，及连续k个人男生人数最大值
 */
public class FindBoy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        int k = scan.nextInt();
        System.out.println(findBoy(string));
        System.out.println(mostInGroup(string,k));

    }
    public static int mostInGroup(String string, int k) {
        int head = 0, tail = 0, cnt = 0, max = 0;
        for (int i = 0 ; i < string.length(); i++ ) {
            tail++;
            if (string.charAt(i) == 'b') {
                cnt++;
            }
            if (tail - head  > k) {
                if (string.charAt(head) == 'b') {
                    cnt--;
                }
                head++;
            }
            max = Math.max(cnt,max);
        }
        head = string.length() - k; tail = 0;
        for (int i = 0; i < k; i++) {
            tail++;
            if (string.charAt(i) == 'b') {
                cnt++;
            }
            if (string.charAt(head) == 'b') {
                cnt--;
            }
            head++;
            max = Math.max(cnt,max);
        }
        return max;
    }

    public static int findBoy(String arr) {
        String[] girlGroup = arr.split("b");
        if (girlGroup[0].equals(arr)) {
            return -1;
        }
        if (arr.charAt(0) == 'b' && arr.charAt(0) == arr.charAt(arr.length() - 1)) {
            int l1 = girlGroup[1].length(), l2 = girlGroup[2].length();
            int boy = l1+1;
            int max = l1 + l2;
            int index = l1 + l2 + 2;
            return findBoyIndex(l1, l2, boy, max, index, girlGroup);
        }else if (arr.charAt(0) == 'b' && arr.charAt(arr.length() - 1) != 'b'){
            int l1 = girlGroup[girlGroup.length-1].length(), l2 = girlGroup[1].length();
            int boy = 0;
            int max = l1 + l2;
            int index = 0;
            return findBoyIndex(l1, l2, boy, max, index, girlGroup);
        }else if (arr.charAt(0) != 'b' && arr.charAt(arr.length() - 1) == 'b'){
            int l2 = girlGroup[girlGroup.length-1].length();
                 int  l1 = girlGroup[0].length();
            int boy = arr.length();
            int max = l1 + l2;
            int index = l1;
            return findBoyIndex(l1, l2, boy, max, index, girlGroup);
        }else if (arr.charAt(0) != 'b' && arr.charAt(arr.length() - 1) != 'b') {
            int l1 = girlGroup[girlGroup.length-1].length(), l2 = girlGroup[0].length();
            int boy = l1;
            int max = l1 + l2;
            int index = l1;
            return findBoyIndex(l1, l2, boy, max, index, girlGroup);
        }
        return -1;//////////
    }

    private static int findBoyIndex(int l1, int l2, int boy, int max, int index, String[] girlGroup){
        for (int i = 1; i < girlGroup.length; i++) {
            index++;
            if ((girlGroup[i].length() + l2 == max && index < max )|| (girlGroup[i].length() + l2 > max)) {
                max = girlGroup[i].length() + l2;
                boy = index;
            }
            l2 = girlGroup[i].length();
            index += l2;
        }
        return boy;
    }
}
