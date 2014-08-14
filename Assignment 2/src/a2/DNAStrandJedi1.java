package a2;

public class DNAStrandJedi1 {
	
	private String DNAStrand;
	DNAStrandJedi1(String DNAStrand){
		this.DNAStrand = DNAStrand;
		if(check_input()){
			throw new RuntimeException("Illegal DNA strand");
		}
	}
	public int getACount(){
		int count_A=0;
		for(int i = 0; i<DNAStrand.length(); i++){
			if(DNAStrand.charAt(i)=='A'){
				count_A+=1;
			}
		}
		return count_A;
	}
    public int getCCount(){
		int count_C=0;
		for(int i = 0; i<DNAStrand.length(); i++){
			if(DNAStrand.charAt(i)=='C'){
				count_C+=1;
			}
		}
		return count_C;
	}
    public int getGCount(){
		int count_G=0;
		for(int i = 0; i<DNAStrand.length(); i++){
			if(DNAStrand.charAt(i)=='G'){
				count_G+=1;
			}
		}
		return count_G;
	}
    public int getTCount(){
		int count_T=0;
		for(int i = 0; i<DNAStrand.length(); i++){
			if(DNAStrand.charAt(i)=='T'){
				count_T+=1;
			}
		}
		return count_T;
	}
    public String getStrandString(){
    	return DNAStrand;
    }
    public int getLength(){
    	return DNAStrand.length();
    }
    boolean check_input(){
    	for(int i = 0; i<DNAStrand.length(); i++){
    		if(DNAStrand.charAt(i)!='A' && DNAStrand.charAt(i)!='C' && DNAStrand.charAt(i)!='G' && DNAStrand.charAt(i)!='T'){
    			return true;
    		}
    	}
    	return false;
    }
    public int getCount(String pattern){
    	int count_pattern = 0;
    	for(int i=0; i<=DNAStrand.length()-pattern.length(); i++)  //each time compare one pattern with all the DNA strands.
		    {
			    // divide the string of DNA strand in to several substrings 
				// and compare each substring with pattern.
				// the length of substring should be equal to the length of the pattern
				
				if(DNAStrand.substring(i,i+pattern.length()).equals(pattern))
						{
					        count_pattern+=1;
					        //if DNA stran's substring is equal to the pattern, count number should add 1.
						} 
			
			
		}
    	return count_pattern;
    }

    public int findPattern(String pattern, int startIndex){
    	if(startIndex<0){   //// If startIndex is less than 0, start looking at position 0.
    		startIndex=0;
    	}
    	if(startIndex<DNAStrand.length()){
    		for(int i=startIndex; i<=(DNAStrand.length()-pattern.length()); i++){
    			int count=0; // count the match number of characters in the pattern.
    			for(int j=i; j<pattern.length()+i;j++){
    				if(char_compare(pattern.charAt(count),DNAStrand.charAt(j))){
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
    public DNAStrandJedi snip(String startPattern, String endPattern){
    	int start_index = -1;   // the position of the startPattern occurence of pattern in the strand 
    	int end_index = -1;     // the position of the endPattern occurence of pattern in the strand
    	int startIndex_new_strand; //the position of the new DNA strand occurence in the strand
    	int endIndex_new_strand;  // the position of the end of the new strand
    	if(startPattern==null || startPattern==""){
    		startIndex_new_strand = 0;
    		start_index=0;
    	}
    	else{
    		start_index = findPattern(startPattern,0);  
    		startIndex_new_strand=start_index+startPattern.length();
    	}
    	
    	if (start_index!=-1){   //when startPattern is null or startPattern is found in DNAStrand string
    		if(endPattern==null|| endPattern==""){
    			end_index=DNAStrand.length();
    		}
    		else{
    		    end_index = findPattern(endPattern,startIndex_new_strand);
    		}
    		endIndex_new_strand=end_index;		
    	}
    	else{
    		return null;
    	}
    	if(end_index<0|| startIndex_new_strand==endIndex_new_strand){
    		return null;
    	}
    	else{
    		DNAStrandJedi snip_DNA = new DNAStrandJedi(DNAStrand.substring(startIndex_new_strand,endIndex_new_strand));
    		return snip_DNA; 	
    	}
    }
    public boolean char_compare(char a, char b){
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
   
        
}
