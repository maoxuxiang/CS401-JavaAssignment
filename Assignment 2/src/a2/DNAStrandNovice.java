package a2;

public class DNAStrandNovice {

	private String strand;
	
	public DNAStrandNovice(String strand){
		this.strand = strand;
		
		if(check_characters()){
			throw new RuntimeException("Illegal DNA strand");
		}
	}
	
	public int getACount(){
		char a = 'A';
		char[] chars = strand.toCharArray();
		int num1 = 0;
		for (int i=0; i<chars.length; i++){
			if (a == chars[i])
				num1++;
		}
		return num1++;
		
	}
	
	public int getCCount(){
		char a = 'C';
		char[] chars = strand.toCharArray();
		int num2 = 0;
		for (int i=0; i<chars.length; i++){
			if (a == chars[i])
				num2++;
		}
		return num2++;
		
	}
	
	public int getGCount(){
		char a = 'G';
		char[] chars = strand.toCharArray();
		int num3 = 0;
		for (int i=0; i<chars.length; i++){
			if (a == chars[i])
				num3++;
		}
		return num3++;
		
	}
	
	public int getTCount(){
		char a = 'T';
		char[] chars = strand.toCharArray();
		int num3 = 0;
		for (int i=0; i<chars.length; i++){
			if (a == chars[i])
				num3++;
		}
		return num3++;
		
	}
	
	public String getStrandString(){
		return strand;
	}
	
	public int getLength(){
		char[] chars = strand.toCharArray();
		return chars.length;
	}
	
	private boolean check_characters(){
		int num = getACount() +  getCCount() + getGCount() + getTCount();
		if (num == getLength())
			return false;
		else 
			return true;
		
	}
	
	
}
