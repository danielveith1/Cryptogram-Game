

// I have commented out placeHolder because I may not need it.
public class cryptogram {
	String original, scrambled, placeHolder;




	public cryptogram(String a){
		original=a.toUpperCase();
		scrambled=a.toUpperCase();
		placeHolder=scrambled;


	}
	//creates scrambled from original
	public void scrambler(){
		String alphabet1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		double randomNumberMultiplier=25.999;
		for(int i=0; i<=25; i++){

			int randomInt=(int) (randomNumberMultiplier*Math.random());
			if(alphabet1.substring(i, i+1).equals(alphabet2.substring(randomInt,randomInt+1))){
				i--;
				continue;
			}
			int position=0;
			while(original.length()>position){
				position=original.indexOf(alphabet1.substring(i,i+1),position);
				if(position==-1)
					break;
				scrambled=scrambled.substring(0,position)+alphabet2.substring(randomInt,randomInt+1)+scrambled.substring(position+1);
				position++;

			}
			alphabet2=alphabet2.substring(0, randomInt)+alphabet2.substring(randomInt+1);
			randomNumberMultiplier--;
		}
		
	}
	public void makePlaceHolder(){
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<placeHolder.length();i++){
			if(alphabet.contains(placeHolder.substring(i, i+1)))
				placeHolder=placeHolder.substring(0,i)+"*"+placeHolder.substring(i+1);
		}
	}
	public void replace(String oldLetter, String guess){
		//Search Scrambled for String a to find the position of it.
		//Then Search the original for String b. If the position returned is the same
		// then the guess is correct
		//if the guess is correct, continue with else clause that replaces
		// letters
		if(scrambled.indexOf(oldLetter,0)!=original.indexOf(guess,0)){
			System.out.println("That is not the correct. Try again");
		}
		else{
			int position=0;
			while(original.length()>position){
				position=original.indexOf(guess,position);
				if(position==-1)
					break;
				placeHolder=placeHolder.substring(0,position)+guess+placeHolder.substring(position+1);
				position++;
			}
		}


	}
	//returns original phrase
	public String getOriginal(){
		return original;	
	}
	//returns scrambled phrase
	public String getScrambled(){
		return scrambled;

	}
	public String getPlaceHolder(){
		return placeHolder;
	}
}