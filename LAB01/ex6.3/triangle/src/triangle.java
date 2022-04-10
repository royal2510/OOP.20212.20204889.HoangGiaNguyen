import java.util.Scanner;

public class triangle {
	public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input number");
		int Num= keyboard.nextInt();
		int h = 0;
		for (int i = 1; i <= Num; ++i,h = 0) {
			for ( int space = 1; space <= Num - i; ++space) {
				System.out.print("  ");
			}
			while (h != 2 * i - 1) {
				System.out.print("* ");
		         ++h;
		      }
			  System.out.println();
			}
}
}