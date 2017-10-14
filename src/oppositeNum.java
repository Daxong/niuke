import java.util.Scanner;

public class oppositeNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String intStr = Integer.toString(num);
		String oppositeNum = "";
		for(int i = intStr.length() - 1; i > -1; i--) {
			oppositeNum += intStr.charAt(i);

		}
		int sum = Integer.parseInt(oppositeNum) + num;
		System.out.println(sum);
	}
}
