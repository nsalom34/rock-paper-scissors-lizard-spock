import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RockPaperScissors {
	public static void main(String args[]) {
		
		// VAR DECLARATIONS
		Scanner userInput = new Scanner(System.in);
		Random rng = new Random();
		List<String> choices = Arrays.asList("ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK");
		int playerScore = 0;
		int computerScore = 0;
		int numGames = 0;

		boolean stop = false;
		
		System.out.println("Scissors cut paper, Paper covers rock, "
				+ "Rock crushes lizard,");

		System.out.println("Lizard poisons Spock, "
				+ "Spock smashes scissors, Scissors decapitate lizard, ");

		System.out.println("Lizard eats paper, Paper disproves Spock, "
				+ "Spock vaporizes rock, Rock crushes scissors");
		System.out.println(" ");
		
		
		while (!stop) {
			System.out.println("Type: Rock Paper Scissors Lizard Spock"
					+ " or Quit");
			String computer = choices.get(rng.nextInt(5));
			String user = userInput.nextLine().toUpperCase();
			
			String winner = assessWinner(computer, user, choices);
			
			switch(winner) {
				case "user":
					System.out.println(user + "  beats " + computer + ": YOU " + "WIN!");
					playerScore +=1;
					numGames +=1;
					System.out.println(" ");
				break;
				
				case "computer":
					System.out.println(user + " is beaten by " + computer + ": YOU " + "LOOSE!");
					computerScore +=1;
					numGames +=1;
					break;
				case "draw":
					System.out.println(user + " and " + computer + ": is a tie!");
					numGames +=1;
					System.out.println(" ");
				break;
				
				case "Quit":
					stop = true;
					System.out.println("Good Bye, Thanks for playing");
					System.out.println("You won " + playerScore + " out of " + numGames + " times!");
					System.out.println(" ");
					userInput.close();
				break;
				
				default: 
					System.out.println("Invalid");
					System.out.println(" ");
					break;
			}

		}
	}
	
	private static String assessWinner(String computer, String user, List<String> choices) {
		if(computer.equals(user))
			return "draw";
		if(user.equals("QUIT") || user.equals("Q"))
			return "Quit";
		if(!choices.contains(user))
			return "Not a supported choice";
		
		// USER WINS IF:
		if (computer.equals("ROCK") && user.equals("PAPER") || 
			computer.equals("ROCK") && user.equals("SPOCK") || 
			computer.equals("PAPER") && user.equals("SCISSORS")||
			computer.equals("PAPER") && user.equals("LIZARD")|| 
			computer.equals("SCISSORS") && user.equals("ROCK") || 
			computer.equals("SCISSORS") && user.equals("SPOCK") ||
			computer.equals("LIZARD") && user.equals("ROCK") || 
			computer.equals("LIZARD") && user.equals("SCISSORS") ||
			computer.equals("SPOCK") && user.equals("LIZARD") ||
			computer.equals("SPOCK") && user.equals("PAPER")){
			
			return "user";
		} else {
			return "computer";
		}
		
	}
}
