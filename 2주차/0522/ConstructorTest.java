
class R2 {
	
	int width;
	int height;
	double area;
	
	R2 (int x) {	
		width = x;
		height = x;
		
		make();
	}
	
	R2 (int w, int h) {
		width = w;
		height = h;
		
		make();
	}
	
	void make() {
		area = width * height;
	}
	
	void print() {
		System.out.println("가로" + width + ", 세로" + height + "인 사각형의 면적은 " + area + "입니다.");
	}
}

class C {
	
	int radius;
	double area;
	
	C () {}	
	
	C (int r) {
		radius = r;
		make();
	}
	
	void make() {
		area = radius * radius * 3.14;
	}
	
	void print() {
		System.out.println("반지름이 " + radius + 
				"인 원의 면적은 " + area + "입니다.");
	}
}

class Employee {
	
	String empNo   = "2301";
	String empName = "김수열";	
	int	   salary;
	
	Employee() { }
	
	Employee(String no, String name) {
		 empNo = no;
		 empName = name;
	}
	
	Employee(String no, String name, int input_salary) {
		 empNo = no;
		 empName = name;
		 salary = input_salary;
	}
	
	void print() {
		System.out.println("사번:" + empNo + ", 사원명:" + empName + ", 기본급:" + salary);
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
	
		R2 r1 = new R2(3, 4);
		R2 r2 = new R2(5, 5);
		
		r1.print();
		r2.print();
		
		C c1 = new C();
		c1.radius = 5;
		c1.make();
		c1.print();
		
		C c2 = new C(6);
		c2.print();
		
		R2 r3 = new R2(8); //가로8, 세로8인 사각형
		r3.print();
		
		
		
		
		Employee e1 = new Employee();
		e1.empNo = "2301";
		e1.empName = "김수열";
		e1.salary = 10000;
		
		Employee e2 = new Employee("2302", "홍길동", 10000);
		Employee e3 = new Employee("2023", "나자바");
		
		e1.print(); // "사번:2301, 사원명:김수열, 기본급:10000
		e2.print(); // "사번:2302, 사원명:홍길동, 기본급:10000
		e3.print(); // "사번:2023, 사원명:나자바, 기본급:0
	}

}
