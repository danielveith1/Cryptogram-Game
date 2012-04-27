import java.util.Scanner;


public class tester {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String play="Y";
		while(play.equals("Y")){
		System.out.println("Enter a phrase to scramble.");
		String entry=input.nextLine();
		
		entry.toUpperCase();
		cryptogram x=new cryptogram(entry);
		x.scrambler();
		x.makePlaceHolder();
		System.out.println(x.getOriginal());
		
		while(!x.getOriginal().equals(x.getPlaceHolder())){
			System.out.println(x.getScrambled());
			System.out.println(x.getPlaceHolder());
			System.out.println("Enter a letter to replace and a letter to replace it with.");
			
			String letterReplaced=input.nextLine();
			
			String letterReplacing=input.nextLine();
		
			x.replace(letterReplaced, letterReplacing);
		}
		System.out.println("Would you like to play again? Type Y for yes");
		play=input.nextLine();
		}
	}
}
