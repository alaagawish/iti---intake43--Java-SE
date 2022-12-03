class Complex{
	
	private int real;
	private int imag;
	public Complex(){
		real=imag=0;
	}
	public Complex(int real, int imag){
		
		this.real=real;
		this.imag=imag;
	}
	
	public Complex add (Complex num){
		Complex result=new Complex(this.real+num.real,this.imag+num.imag);
		
		return result; 
	}
	public Complex subtract (Complex num){
		
		return new Complex(this.real-num.real,this.imag-num.imag); 
	}
	public void printComplex(){
		if (this.real>0 && this.imag>0)
			System.out.println(this.real+ " i + "+ this.imag); 
		else if (this.real>0 && this.imag<0)
			System.out.println(this.real+" i "+ this.imag); 
		else if (this.real>0 && this.imag==0)
			System.out.println(this.real); 
		else if (this.real==0 && this.imag>0)
			System.out.println("i + "+ this.imag); 
		else if (this.real==0 && this.imag<0)
			System.out.println("i "+ this.imag); 
		else if (this.real==0 && this.imag==0)
			System.out.println(0); 
	}
	
}

public class ComplexTask{
	
	
	public static void main(String[] args){
		
	
		Complex number1=new Complex(5,7);
		Complex number2=new Complex(3,5);
		Complex result1,result2;
		result1=number1.add(number2);
		result2=number1.subtract(number2);
		System.out.print("result of addition = ");
		result1.printComplex();
		System.out.print("result of subtraction = " );
		result2.printComplex();
		
		
	}
	
	
}
