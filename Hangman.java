/*HEADER:
 * Name: Iqra Mumtaz
 * Roll No.: L14-4121
 * Course/Section: Advance Programming (B)
 * E-mail ID: l144121@lhr.nu.edu.pk
 * 
 * Name: Saba Abbas
 * Roll No.:  
 * Course/Section: Advance Programming (A)
 * E-mail ID: l14@lhr.nu.edu.pk
 * 
 * JAVA String and String Buffer
 * HANGMAN - Guess The Word!
 * September 14, 2018
 */

package hangman;

import java.util.Random;	//this library is imported to generate random numbers
import java.util.Scanner;	//this library is imported to get user input from console 

public class Hangman {

	public static void main(String[] args) {
		
		System.out.println("<.<.<.<.<.<.<.<.<.<.. WELCOME  TO  HANGMAN ..>.>.>.>.>.>.>.>.>.>\n\n");
		
		//randomly choosing word to be guessed
		HangmanLexicon Word = new HangmanLexicon();
		
		Random rand = new Random();	//to generate new numbers at random
		int index = rand.nextInt(Word.getWordCount());
				
		String wordToBeGuessed = Word.getWord(index);
		
		//echoing..for developer only commented for end users
		//System.out.println("Random Word Number: " + index);
		System.out.println("Word to be guessed: " + wordToBeGuessed);
		//System.out.println("Word to be guessed is " + wordToBeGuessed.length() + " letters long.");
		
		//creating new string to represent the secret word
		String guessedWord = new String(new char[wordToBeGuessed.length()]).replace("\0", "-");
		
		int wrongGuess = 8;		//counter for wrong guess of users. Maximum 8 guesses to guess the word.
		
		Scanner input = new Scanner(System.in);		//to get input from user
		
		while(true)	//infinite loop; break either when user wins OR user hangs
		{
			//displaying blank spaces '-' instead of word to be guessed
			System.out.print("\nNow, word looks like: " + guessedWord);  
			
			//displaying left wrong guesses to user
			System.out.print("\nLeft Guesses: " + wrongGuess);
			
			//user enter any guess any character to be in secret word
		
			String userGuess;		//it will store input given by user
			
			while(true)		//taking user input until not provide legal input
			{
				System.out.print("\nEnter your guess: ");
				userGuess = input.next();
			
				//checking the legal user input either 'A' OR 'a' 
				//all rest inputs are illegal
		
				if ( !( ( userGuess.charAt(0) >= 'A' && userGuess.charAt(0) <= 'Z') || (userGuess.charAt(0) >= 'a' && userGuess.charAt(0) <= 'z' ) ))
				
				{
					System.out.println("\n  ILLEGAL INPUT  \n");
				}
				
				else
				{
					break;
				}			
			}
			
			String guessChar = userGuess.toUpperCase();		//converting an input (user guess to the secret word into upper case)
						
			String tempGuessed = "";
			
			if ( (wordToBeGuessed.contains(guessChar)) )
			
			{			
				for (int i = 0; i < wordToBeGuessed.length(); i++) 
				{
					if (wordToBeGuessed.charAt(i) == guessChar.charAt(0)) 
					{
					//	StringBuffer die = new StringBuffer (temp+guessChar.charAt(i));						
						//temp = die.toString();
						tempGuessed = tempGuessed + guessChar;		
						System.out.println("1 IF TempGuessed: " +tempGuessed);
					} 
					else if (guessedWord.charAt(i) != '-') 
					{
						
						//StringBuffer die = new StringBuffer (temp+wordToBeGuessed.charAt(i));						
						//temp = die.toString();			
						
						tempGuessed = tempGuessed + wordToBeGuessed.charAt(i);
						System.out.println("2 IF TempGuessed: " +tempGuessed);
						System.out.println("2 IF guessedWord: " +guessedWord);
					} 
					else 
					{
						tempGuessed += "-";
						System.out.println("3 IF TempGuessed: " +tempGuessed);
					}
				}

				tempGuessed.toUpperCase();
				guessedWord = tempGuessed;
			}
	
			//wrong guess by user
			else if (!wordToBeGuessed.contains(guessChar))
			{
				wrongGuess--;
			
				//Game Over condition
				if (wrongGuess == 0)
				{
					System.out.print("\n\nOOPS!! You are out of guesses.\n\n");
					System.out.print("SAD!! You lost the game.\n\n");
					break;
				}		
			}			
			
			//winning condition
			if (!guessedWord.contains("-"))
			{
				System.out.println("\n\nBRAVOO!! you have successfully guessed the word.\n");
				break;
			}					
		}	
		input.close();		//close input object of scanner
	}
}

/*
 * File: HangmanLexicon.java
 * ------------------------
* This file contains a stub implementation of the HangmanLexicon class

*/

class HangmanLexicon {	
	
	/** Returns the number of words in the lexicon. */	
	public int getWordCount() {
		return 10;
	}
	
	/** Returns the word at the specified index. */

	public String getWord(int index) {
		switch (index) {

		case 0:
			return "BUOY";
		case 1:
			return "COMPUTER";
		case 2:
			return "CONNOISSEUR";
		case 3:
			return "DEHYDRATE";
		case 4:
			return "FUZZY";
		case 5:
			return "HUBBUB";
		case 6:
			return "KEYHOLE";
		case 7:
			return "QUAGMIRE";
		case 8:
			return "SLITHER";
		case 9:
			return "ZIRCON";
		default:
			return new String("Illegal index");
		}
	}
}

/*   Test Case Input 1
 * <.<.<.<.<.<.<.<.<.<.. WELCOME  TO  HANGMAN ..>.>.>.>.>.>.>.>.>.>


Random Word Number: 0
Word to be guessed: BUOY
Word to be guessed is 4 letters long.

Now, word looks like: ----
Left Guesses: 8
Enter your guess: a

Now, word looks like: ----
Left Guesses: 7
Enter your guess: O

Now, word looks like: --O-
Left Guesses: 7
Enter your guess: y

Now, word looks like: --OY
Left Guesses: 7
Enter your guess: b

Now, word looks like: B-OY
Left Guesses: 7
Enter your guess: U


BRAVOO!! you have successfully guessed the word.
 */

/*		Test Case Input 2
 *<.<.<.<.<.<.<.<.<.<.. WELCOME  TO  HANGMAN ..>.>.>.>.>.>.>.>.>.>


Random Word Number: 1
Word to be guessed: COMPUTER
Word to be guessed is 8 letters long.

Now, word looks like: --------
Left Guesses: 8
Enter your guess: a

Now, word looks like: --------
Left Guesses: 7
Enter your guess: e

Now, word looks like: ------E-
Left Guesses: 7
Enter your guess: i

Now, word looks like: ------E-
Left Guesses: 6
Enter your guess: o

Now, word looks like: -O----E-
Left Guesses: 6
Enter your guess: u

Now, word looks like: -O--U-E-
Left Guesses: 6
Enter your guess: 
w

Now, word looks like: -O--U-E-
Left Guesses: 5
Enter your guess: p

Now, word looks like: -O-PU-E-
Left Guesses: 5
Enter your guess: m

Now, word looks like: -OMPU-E-
Left Guesses: 5
Enter your guess: f

Now, word looks like: -OMPU-E-
Left Guesses: 4
Enter your guess: d

Now, word looks like: -OMPU-E-
Left Guesses: 3
Enter your guess: h

Now, word looks like: -OMPU-E-
Left Guesses: 2
Enter your guess: e

Now, word looks like: -OMPU-E-
Left Guesses: 2
Enter your guess: r

Now, word looks like: -OMPU-ER
Left Guesses: 2
Enter your guess: y

Now, word looks like: -OMPU-ER
Left Guesses: 1
Enter your guess: s


OOPS!! You are out of guesses.

SAD!! You lost the game. 
*/