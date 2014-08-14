package a3adept;

public class test {
	
	public static void main(String[] args) {
		int a[] = new int[] {1, 2, 3};
		int b[] = new int[] {4, 5, 6};
		int c[] = new int[] {a[0], b[1], a[2]};
		b = a;
		a = c;
		c = b;
		int d = a[0] + b[1] + c[2];
		System.out.print(d);
	}

}
