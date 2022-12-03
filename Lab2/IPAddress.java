
import java.util.StringTokenizer;
class IPAddress{
	
	public static void main(String[] args){
			
		String iPAddress=args[0];
		//using string tokenizer
		StringTokenizer stringTokenizer = new StringTokenizer(iPAddress,"\\.");
		while (stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}
		 
    
    //using regex
    
    
    String [] splittedString=iPAddress.split("\\.");
		for(int i=0;i< splittedString.length;i++){
			
			System.out.println(splittedString[i]);
			
		}
		//OR 
		String s=iPAddress.replaceAll("\\.","\n");
		System.out.print(s);
    
    
    //using substring
    
    
		int index=iPAddress.indexOf(".");
		System.out.println(iPAddress.substring(0,index));
		for(int i=0; i<2 ;i++){
			iPAddress=iPAddress.substring(index+1);
			index=iPAddress.indexOf(".");
			System.out.println(iPAddress.substring(0,index));
		
		}
		System.out.println(iPAddress.substring(index+1));
		
	
		
		
	}
	
	
}
