package testing;



class A {
	void eval(int x){

	}
	
}

class B extends A  {
	public void eval(int x){
		if (x == 0)
			throw new RuntimeException();
		System.out.println("Evaluating...");
	}
}

public class ExceptionDemo {
	public static void main(String[] args) {
		B obj = new B();
		try{
		obj.eval(0);
	}
	catch(Exception e){
		System.out.println("Exception handled");
	}
	System.out.println("dgfsg");
}
}