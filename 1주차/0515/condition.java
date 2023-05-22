import java.util.Scanner;

public class condition {
	public static void main(String[] args) { 
						
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위바위보");
		System.out.print("가위는 1, 바위는 2, 보는 3을 입력하세요: ");
		
		int user = Integer.parseInt(sc.nextLine());
		int com = (int)(Math.random() * 3) + 1;
		
		System.out.print("상대: ");		
		if      (com == 1) System.out.println("가위");
		else if (com == 2) System.out.println("바위");
		else if (com == 3) System.out.println("보");
								
		if (user == com)
			System.out.println("비겼습니다!");
		else
		{
			if ((user == 1 && com == 3) ||
				(user == 2 && com == 1) ||
				(user == 3 && com == 2))
				System.out.println("이겼습니다!");
			else
				System.out.println("졌습니다!");
		}
	}
}
