package dto;

public class MemberStu {
	
	private String name;
	private int age;
	private int eng;
	private int math;
	
	public MemberStu() {
		
	}
	
	public MemberStu(String name, int age, int eng, int math) {
		super();
		this.name = name;
		this.age = age;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return name + "-" + age + "-" + eng + "-" + math;
	}
	
	
	
}
