import java.util.*;
public class DotComBust {

private GameHelper helper = new GameHelper();
private ArrayList<DotCom> dotComsList = new ArrayList<DotCom> ();
private int numOfGuesses = 0;

private void setUpGame () {
	//dotcom creation area
	DotCom one =  new DotCom ();
	one.setName ("Amazon.com");
	DotCom two =  new DotCom ();
	two.setName ("Google.com");
	DotCom three =  new DotCom ();
	three.setName ("Facebook.com");
	dotComsList.add(one);
	dotComsList.add(two);
	dotComsList.add(three);
	System.out.println("Your goal is to destroy the global technocracy!");
	System.out.println("Amazon.com, Google.com, Facebook.com");
	System.out.println("May your strikes be precise and true against the censorship!");
	
	for (DotCom dotComToSet : dotComsList) {
		ArrayList<String> newLocation = helper.placeDotCom(3);
		dotComToSet.setLocationCells(newLocation);
	}
}
private void startPlaying() {
	while (!dotComsList.isEmpty()) {
		String userGuess = helper.getUserInput("Launch a nuke where?");
				checkUserGuess (userGuess);
	}
	finishGame();
}
private void checkUserGuess (String userGuess) {
	numOfGuesses++;
	String result = "miss";
	for (int x = 0; x < dotComsList.size(); x++) {
		result = dotComsList.get (x).checkYourself (userGuess);
		if (result.equals("hit")) {
			break;
		}
		if (result.equals("kill")) {
			dotComsList.remove(x);
			break;
		}
	}
	System.out.println(result);
}
private void finishGame() {
	System.out.println("The global technocracy has been defeated! The internet is free! Meme on dudes!");
	if (numOfGuesses <= 18) {
		System.out.println("You used your nukes conservatively! " + numOfGuesses +  "nukes used. Casualties minimal.");
		System.out.println("You exposed the Chinese spy grid threatening the world. The world awakens to a new dawn.");
	}
	else {
		System.out.println("The stench of dead bodies fills the air. " + numOfGuesses + " nukes used. Are you a terrorist or a hero?");
		System.out.println("The day dawns and you find yourself in a prison cell. So much death. Maybe you deserve to be here.");
	}
	
}
public static void main (String[] args) {
	DotComBust game = new DotComBust();
	game.setUpGame();
	game.startPlaying();
}
}
