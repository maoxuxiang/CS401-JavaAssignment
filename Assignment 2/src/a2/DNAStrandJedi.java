package a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNAStrandJedi {

private String strand;
	
	public DNAStrandJedi(String strand){
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
	    		case '*': return true;
	        	case 'c': return true;        	
	        	case 'g': return true;        	
	        	case 't': return true;
	        	default: return false;
	        	}
	    	}
	    	if(b=='C'){
	    		switch (a){
	        	case 'a': return true;       	
	        	case '*': return true;
	        	case 'C': return true;        	
	        	case 'g': return true;        	
	        	case 't': return true; 	
	        	default: return false;
	        	}
	    	}
	    	if(b=='T'){
	    		switch(a){
	    		case 'a': return true;
	    		case 'c': return true;
	    		case 'T': return true;
	    		case 'g': return true;
	    		case '*': return true;
	    		default: return false;
	    		}
	    	}
	    	if(b=='G'){
	    		switch(a){
	    		case 'a': return true;
	    		case 'c': return true;
	    		case 'G': return true;
	    		case 't': return true;
	    		case '*': return true;
	    		default: return false;
	    		}
	    	}
	    	return false;
	    }	

	
	public int count(String pattern, String str){
		int count =0;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		
		while(m.find()){
			count++;
		}		
	
		return count;
	}
	
	public DNAStrandJedi snip(String startPattern, String endPattern) {
		int indexBegin, indexEnd, indexBegin_end;
		
		if ( startPattern == null || startPattern == "" ){
	        indexBegin = 0;
	        indexBegin_end = indexBegin;
		}
		
		else  {
			if (getCount(startPattern) == 0)
				return null;
			else{
				indexBegin = strand.indexOf(startPattern);	
				indexBegin_end = indexBegin + startPattern.length();
			}
		}
		
		if (endPattern == "" || endPattern == null )
			indexEnd = strand.length();
		else{
			if (getCount(endPattern) == 0)
				return null;
			else
			indexEnd = strand.indexOf(endPattern,indexBegin_end);
		}
		    
		if (indexEnd == indexBegin_end)
		    return null;
		
		String snipString = strand.substring(indexBegin_end, indexEnd);
		
		return new DNAStrandJedi(snipString);
	}
		
}
	

