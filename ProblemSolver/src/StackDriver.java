import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackDriver {

	public static void main(String[] args) throws FileNotFoundException{
		
		File problem1 = new File ("problem1.txt");
		Scanner s1 = new Scanner(problem1);

		while(s1.hasNext()) {
			System.out.println(problemO(s1));
		}
		
		
		
		
	
	}
	public static String problemO(Scanner s){
		String stringHolder = s.nextLine();
		stringHolder.trim();
		char character;
		String charNum;
		LinkedStack stack = new LinkedStack();
		String patternOne = "\\w";
		
		
		for(int i = 0; i < stringHolder.length();i++) {
			character = stringHolder.charAt(i);
			charNum = Character.toString(character);
			if(charNum != " ") {
				try {
					if(charNum.equals("(") || charNum.equals("{") || charNum.equals("[") ) {
						stack.push(charNum);	
					}
					if(charNum.equals(")") || charNum.equals("]") ||charNum.equals("}")) {
						if(charNum.equals(")") && stack.top().equals("(") && stack.size() != 0) {
							stack.pop();
						}
						if(charNum.equals("]") && stack.top().equals("[")&& stack.size() != 0) {
							stack.pop();
						}
						if(charNum.equals("}") &&  stack.top().equals("{")&& stack.size() != 0) {
							stack.pop();
						}
					}
				}catch(Exception e) {
					return "Incorrect";
				}
				
			}
		}
		if(stack.size() > 0) 
			return "Incorrect";
		
		for(int j = 0; j < stringHolder.length();j++) {
			character = stringHolder.charAt(j);
			charNum = Character.toString(character);
			if(charNum != " "){
					if(charNum.matches(patternOne) ) {
						stack.push(charNum);
					}
			
					if(charNum.equals("+") || charNum.equals("/") || charNum.equals("*") || charNum.equals("-") || charNum.equals("%")) {
						if(j == 0) {return "Incorrect";}
						if(j == stringHolder.length()-1) {return "Incorrect";}
						if(stack.top().toString().matches(patternOne)) {
							
							stack.push(charNum);
						}else{
							System.out.println(charNum + " "+ stack.top());
							return "Incorrect";
						}
				}
			}
		}
		
		return "Correct";	
}

	
	public static String problemOne(Scanner n) {
		   String stringHolder = n.nextLine();
		   char charHolder;
		   stringHolder.trim();
		   Stack s = new Stack();
		   int i = 0;
		   int paraCount = 0;
		   int bracketCount = 0;
		   int curlyCount = 0;
		   int operatorCount = 0;
			for(i = 0; i < stringHolder.length();i++) {
			    charHolder = stringHolder.charAt(i);
				if(charHolder != ' '){
			    	  if(charHolder == '(') {
						  s.push(charHolder);
						  paraCount++;
					  }
				      if(charHolder == ')'){
						   s.pop();
						   paraCount--;
				      }
				      if(charHolder == '[') {
						   s.push(charHolder);
						   bracketCount++;
					  }
					  if(charHolder == ']' ) {
						   s.pop();
						   bracketCount--;
					  }
					  if(charHolder == '{') {
						   s.push(charHolder);
						  curlyCount++;
					  }
					  if(charHolder == '}') {
						   s.pop();
						   curlyCount--;
					  }
					  if(charHolder == '+' || charHolder == '/' || charHolder == '*' || charHolder == '-' || charHolder == '%') {
						operatorCount++;
						if(i == 0 ) {
							return "Incorrect";
						}
					    if(i == stringHolder.length() - 1) {
					    	return "Incorrect";
					    }
					    if(stringHolder.charAt(i+1) == '+' || stringHolder.charAt(i+1) == '/' 
					    		|| stringHolder.charAt(i+1) == '*' || stringHolder.charAt(i+1) == '-' || charHolder == '%') {
						  operatorCount++;
				    	}else {
						  operatorCount--;
						}
					    
					    
					}  
				}	 
			}
			if( bracketCount == 0 && curlyCount == 0 && paraCount == 0 && operatorCount == 0 && s.size() == 0) {
			  return "Correct";
			}else {
			  return "Incorrect";
		  	}
	}
}
