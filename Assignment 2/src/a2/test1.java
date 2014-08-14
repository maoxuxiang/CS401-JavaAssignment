package a2;



public class test1 {
	
	public static void main (String[] args){
		DNAStrandAdept ss = new DNAStrandAdept("ACGTTACAC"); 
		System.out.println(ss.findPattern("AC", 4));
	}

	
}
