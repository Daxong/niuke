import java.util.Scanner;

public class Coin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coin = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(coin > 0) {
			if(coin % 2 == 0) {
				coin = (coin - 2) / 2;
				sb.append("2");
			} else {
				coin = (coin - 1) / 2;
				sb.append("1");
			}
		}
		System.out.println(sb.reverse().toString());
	}
}
