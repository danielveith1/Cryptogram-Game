

//welcome to Dan's cryptogram object. Rough draft.
public class cryptogram {
	private String original, scrambled; 

	// constructor makes a new cryptogram object from a string input 
	// but does not scramble it yet.
	public cryptogram(String a){
		original=a;
		scrambled=a;
	}
	//creates scrambled from original 
	public void scrambler(){
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String usedLetters="";
		for(int i=0; i<=25; i++){
			int randomInt=(int) (25.999*Math.random());
			if(randomInt==i){
				i--;
				continue;
			}

			if(usedLetters.contains(alphabet.substring(randomInt,randomInt+1))){
				i--;
				continue;
			}

			usedLetters=usedLetters+alphabet.substring(randomInt,randomInt+1);
			int position=0;
			while(original.length()>position){
				position=search(original,alphabet.substring(i,i+1),position);
				if(position==-1)
					break;
				scrambled=scrambled.substring(0,position)+alphabet.substring(randomInt,randomInt+1)+scrambled.substring(position+1);
				position++;

			}
		}

	}
	// replaces swaps letters in scrambled if your guess is correct
	public void replace(String oldLetter, String guess){
		//Search Scrambled for String a to find the position of it. 
		//Then Search the original for String b. If the position returned is the same
		// then the guess is correct
		//if the guess is correct, continue with else clause that replaces
		// letters
		if(search(scrambled,oldLetter,0)!=search(original,guess,0)){
			System.out.println("That is not the correct. Try again");
		}
		else{
			int position=0;
			while(original.length()>position){
				position=search(original,guess,position);
				if(position==-1)
					break;
				scrambled=scrambled.substring(0,position)+guess+scrambled.substring(position+1);
				position++;
			}
		}


	}
	// This may be redundant but I am using it to find the position in the string of certain letters.
	// 
	public int search(String searchedWord, String letter,int pos){
		int newPosition=searchedWord.indexOf(letter, pos);
		return newPosition; 
	}

	//returns original phrase
	public String getOriginal(){
		return original;	
	}
	//returns scrambled phrase
	public String getScrambled(){
		return scrambled;

	}

}