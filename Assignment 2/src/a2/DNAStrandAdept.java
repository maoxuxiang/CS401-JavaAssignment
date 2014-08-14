package a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNAStrandAdept {

private String strand;
	
	public DNAStrandAdept(String strand){
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
	
	public int getCount(String pattern){
		int count = 0;	
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(strand);
		while(m.find()){
			count++;
		}		
		return count;
	}
	
	 public int findPattern(String pattern, int startIndex){
	    	if(startIndex<0){   //// If startIndex is less than 0, start looking at position 0.
	    		startIndex=0;
	    	}
	    	if(startIndex<strand.length()){
	    		for(int i=startIndex; i<=(strand.length()-pattern.length()); i++){
	    			int count=0; // count the match number of characters in the pattern.
	    			for(int j=i; j<pattern.length()+i;j++){
	    				if(match(pattern.charAt(count),strand.charAt(j))){
	        				count+=1; 
	        			}
	    				else{
	    					break;
	    				}
	    				if(count==pattern.length()){
	        				return i;
	        			}
	    			}	
	    		}
	    			
	    	}
	    	return -1;
	    }
	 
	 public boolean match(char a, char b){
	    	if(b=='A'){
	    		switch (a){
	    		case 'A': return true;
	        	default: return false;
	        	}
	    	}
	    	if(b=='C'){
	    		switch (a){
	          	case 'C': return true;        	
	        	default: return false;
	        	}
	    	}
	    	if(b=='T'){
	    		switch(a){
	    		case 'T': return true;
	    		default: return false;
	    		}
	    	}
	    	if(b=='G'){
	    		switch(a){
	    		case 'G': return true;
	    		default: return false;
	    		}
	    	}
	    	return false;
	    }	
		
	}
	

