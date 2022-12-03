class Calculator{
	
	public static void main(String[] args){
	
		
		if(args.length < 3) {
			System.out.println("something missed in equation, enter all parts");
			System.exit(0);
		}
		else{
			String operation=args[1];
			int number1=Integer.parseInt (args[0]);
			int number2=Integer.parseInt (args[2]);
			int result;
		
			
			switch(operation){
			
				case "x":
					result=number1*number2;
					break;
				case "+":
					result=number1+number2;
					break;
				case "-":
					result=number1-number2;
					break;
					
				case "/":
					if(number2==0){
						System.out.println("error division by zero");
						return;
					}
					else
						result=number1/number2;
					break;
				default:
					result=0;
			
			
			}
			
			System.out.println(result);
		
		}
		
		
	}
	
	
}
