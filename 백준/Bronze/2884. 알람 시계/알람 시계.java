import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(H>0)
		{
			if(H<24)
				{
					if(M>=0)
					{
						if(M<60)
						{
							if(M-45>=0)
								System.out.println(H + " "+ (M-45));
							else
								System.out.println((H-1) + " " + (60+(M-45)));
						}
					}
				}
		}
		else if(H==0)
		{
			if(M>=0)
			{
				if(M<60)
				{
					if(M-45>=0)
						System.out.println(H + " "+ (M-45));
					else
						System.out.println(23 + " " + (60+(M-45)));
				}
			}
		}
		sc.close();
	}

}
