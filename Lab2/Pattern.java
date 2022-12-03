
import java.io.Console;
public class Pattern{
	
	
	public static void main(String[] args){
		
		int numberOfLines=Integer.parseInt(args[0]); 

		
		if(args.length ==0) {
			System.out.println("something missed in equation, enter all parts");
			System.exit(0);
		}
		else{
			int j = 1+2*numberOfLines; 
			String first="*",second="* ";
			String pattern1=first ,pattern2=second;
			
			for(int i = 0; i < numberOfLines; j-=2, i++) {
				System.out.print(pattern1);
				System.out.printf("%"+j+"s", " ");
				System.out.print(pattern2);
				pattern1+=first;
				pattern2+=second;
							
				System.out.println("");
			}
		}

	
	}
	
	
}
