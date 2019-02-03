import java.util.*;

public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	public void setLocationCells (ArrayList<String> loc) {
		locationCells = loc;
	}
	public void setName (String n) {
		name =n;
	}
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("An arm of Chinese censorship is destroyed!" + name + "  : ) ");
				
			}
			else {
				result = "hit";
				System.out.println("You feel the internet shudder as your nuke hits it's target...");
			}
		}
		return result;
		
		
	}
}


