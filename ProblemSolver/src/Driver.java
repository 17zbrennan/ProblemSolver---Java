import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		File f1 = new File("problem1.txt");
		Scanner s1 = new Scanner(f1);
		
		while(s1.hasNext()) {
			
			System.out.println(problemOne(s1));
		}
	}
	
	
	public static String problemOne(Scanner s){
		String stringHolder = s.nextLine();
		stringHolder.trim();
		char character;
		String charNum;
		LinkedStack stack = new LinkedStack();
		System.out.println(stringHolder);
		for(int i = 0; i > stringHolder.length();i++) {
			character = stringHolder.charAt(i);
			charNum = Character.toString(character);
			if(charNum != " ") {
				if(charNum.equals("(") || charNum.equals("{") || charNum.equals("[") ) {
				stack.push(stringHolder);	
				}
				if(charNum.equals(")") || charNum.equals("]") ||charNum.equals("}")) {
					if(charNum.equals(")") & stack.top().equals("(")) {
						stack.pop();
					}
					if(charNum.equals("]") &  stack.top().equals("[")) {
						stack.pop();
					}
					if(charNum.equals("}") &  stack.top().equals("{")) {
						stack.pop();
					}
				}
				if(stack.size() > 0) {
					return "Incorrect";
				}
			}
		}
		return "Correct";
	}
}
