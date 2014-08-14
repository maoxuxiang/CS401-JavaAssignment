package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		System.out.println("input:");
		Scanner s = new Scanner(System.in);
		
		process(s);
		
        
        s.close();
		// TODO Auto-generated method stub
        
	}
	
	
	
	public static void process(Scanner s) {
		// set variable to store number of letters 
	      int num11 = 0;
		  int num21 = 0;
	   	  int num31 = 0;
		  int num41 = 0;
		
		// set a value used for compare high or low
		  double minA = Double.POSITIVE_INFINITY;
		  int maxA = -1;
		  double minC = Double.POSITIVE_INFINITY;
		  int maxC = -1;
		  double minG = Double.POSITIVE_INFINITY;
		  int maxG = -1;
		  double minT = Double.POSITIVE_INFINITY;
		  int maxT = -1;
		  
		  //used for store final string
		  String MinA = "";
		  String MaxA = "";
		  String MinC = "";
		  String MaxC = "";
		  String MinG = "";
		  String MaxG = "";
		  String MinT = "";
		  String MaxT = "";
		
		  while (true){
			  
			  
			  //get the input
			 String str = s.next();
			 

			 if (str.equals("end")){			   
				    System.out.println("A count:" + num11);
				    System.out.println("C count:" + num21);
				    System.out.println("G count:" + num31);
				    System.out.println("T count:" + num41);
				    System.out.println("Low A count"+ " " + MinA);
					System.out.println("High A count"+ " " + MaxA);
					System.out.println("Low C count"+ " " + MinC);
					System.out.println("High C count"+ " " + MaxC);
					System.out.println("Low G count"+ " " + MinG);
					System.out.println("High G count"+ " " + MaxG);
					System.out.println("Low T count"+ " " + MinT);
					System.out.println("High T count"+ " " + MaxT);
					  break;
			 }
			 
			 else{
				char a = 'A';
				char b = 'C';
				char c = 'G';
				char d = 'T';
				
				int num1 = 0;
				int num2 = 0;
				int num3 = 0;
				int num4 = 0;
				
				char[] chars = str.toCharArray();
							   
			    // for loop used for counting how many times each letter occurred in total and in each string.
				for(int i = 0; i < chars.length; i++)
				{
							
					if (a == chars[i])
					{
						num1++;
						num11++;
					}
					else if (b == chars[i])
					{
						num2++;
						num21++;
					}
					else if (c == chars[i])
					{
						num3++;
						num31++;
					}
					else if (d == chars[i])
					{
						num4++;
						num41++;
					}
				}
				  
				
				//get the high and low count string
				  if (0 <= num1 & num1 < minA ){
					  minA = num1;
					  MinA = str;
					  
				
				  }
				  if (num1 > maxA){
					  maxA = num1;
					  MaxA = str;
					  
				  }
				  if (0<= num2 & num2 < minC){
					  minC = num2;  
					  MinC = str;
				  }
				  if (num2 > maxC){
					  maxC= num2;
					  MaxC = str;
					
				  }
				  if (0<= num3 &num3 < minG){
					  minG = num3;
					  MinG = str;
					 
				  }
				  if (num3 > maxG){
					  maxG= num3;
					  MaxG = str;
					 
				  } if (0<= num4 &num4 < minT){
					  minT = num4;
					  MinT = str;
					
				  }
				  if (num4 > maxT){
					  maxT= num4;
					  MaxT = str;
					
				  }

				  
				
			 }
			 
				  
			}
		
		  
    }
}
	