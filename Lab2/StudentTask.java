
class Student{
	private int age;
	private String name;
	private String track;
	
	public Student(){}
	public Student(String name, String track,int age){
		this.age=age;
		this.name=name;
		this.track=track;
		
	}
	public void setAge(int age){
		
		this.age=age;
	}
	public void setName(String name){
		
		this.name=name;
	}
	
	public void setTrack(String track){
		
		this.track=track;
	}
	public int getAge(){
		return this.age;
	}
	public String getName(){
		return this.name;
	}
	public String getTrack(){
		return this.track;
	}
	
	
	
}
public class StudentTask{
	
	
	public static void main(String[] args){
		
		Student student=new Student("Karim", "Mobile",22);
		Student student2=new Student();
		student2.setName("Mohamed");
		student2.setAge(24);
		student2.setTrack("IC");
		
		System.out.println(student.getName()+" from track: "+student.getTrack()+" is "+student.getAge()+" y.o.");		
		
		System.out.println(student2.getName()+" from track: "+student2.getTrack()+" is "+student2.getAge()+" y.o.");	
		
		
		
	}
	
	
}
