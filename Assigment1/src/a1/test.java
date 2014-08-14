package a1;

public class test {

	public static void main(String[] args) {
		A a = new A();
		a.methodA(1, 2);
		a.methodA(1.5, 2.5);
		a.methodA(1, 2.5);
		a.methodA(1.5, 2);
		
	}

}

class A {
	
	static void methodA(int a, int b) {
		System.out.println("methodA was called with 2 integers: " + a + ", and " + b);
	}

	static void methodA(double a, double b) {
		System.out.println("methodA was called with 2 doubles: " + a + ", and " + b);
	}

	static void methodA(int a, double b) {
		System.out.println("methodA was called with integer " + a + ", and double " + b);
	}

	static void methodA(double a, int b) {
		System.out.println("methodA was called with double " + a + ", and integer " + b);
	}

}