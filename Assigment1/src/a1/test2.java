package a1;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		System.out.println("input:");
		Scanner s = new Scanner(System.in);
		
		process1(s);
		
        
        s.close();
		// TODO Auto-generated method stub
        
	}
	
	public static void process(Scanner s) {
		//store the input into a string
	
		// int for storing the times
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		// when input is end, it ends. 
		  while (true){  
				String str = s.next();   
				
				if(str.equals("end")){
					 System.out.println("A count:" + num1);
					  System.out.println("C count:" + num2);
					  System.out.println("G count:" + num3);
					  System.out.println("T count:" + num4);
				 }
				else {
				char a = 'A';
				char b = 'C';
				char c = 'G';
				char d = 'T';
				
				// store every character into a array 
				char[] chars = str.toCharArray();
				for(int i = 0; i < chars.length; i++)
				{
					if (a == chars[i])
				{
					num1++;
				}
				else if (b == chars[i])
				{
					num2++;
				}
				else if (c == chars[i])
				{
					num3++;
				}
				else if (d == chars[i])
				{
					num4++;
				}
				}
				
				}
				
			}
		 
		  //close scanner
		  
		
    }
	
	public static void process1(Scanner s) {
		
		int num11 = 0;
		int num21 = 0;
		int num31 = 0;
		int num41 = 0;
		
		
		  int minA = 999;
		  int maxA = -1;
		  int minC = 999;
		  int maxC = -1;
		  int minG = 999;
		  int maxG = -1;
		  int minT = 999;
		  int maxT = -1;
		  
		  String MinA = "";
		  String MaxA = "";
		  String MinC = "";
		  String MaxC = "";
		  String MinG = "";
		  String MaxG = "";
		  String MinT = "";
		  String MaxT = "";
		
		  while (true){
			  
			 String str = s.next();
			 

			 if (str.equals("end")){			   
				 System.out.println("A count:" + num11);
				  System.out.println("C count:" + num21);
				  System.out.println("G count:" + num31);
				  System.out.println("T count:" + num41);
				    System.out.println("A max"+ MaxA);
					System.out.println("A min"+ " " + MinA);
					System.out.println("C max"+ " " + MaxC);
					System.out.println("c min"+ " " + MinC);
					System.out.println("G max"+ " " + MaxG);
					System.out.println("G min"+ " " + MinG);
					System.out.println("G max"+ " " + MaxT);
					System.out.println("G min"+ " " + MinT);
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
				  
				
				 /* System.out.println("A count:" + num1);
				  System.out.println("C count:" + num2);
				  System.out.println("G count:" + num3);
				  System.out.println("T count:" + num4);
				  */
				  
				  if (1 <= num1 & num1 < minA ){
					  minA = num1;
					  MinA = str;
					  
				
				  }
				  if (num1 > maxA){
					  maxA = num1;
					  MaxA = str;
					  
				  }
				  if (1<= num2 & num2 < minC){
					  minC = num2;  
					  MinC = str;
				  }
				  if (num2 > maxC){
					  maxC= num2;
					  MaxC = str;
					
				  }
				  if (1<= num3 &num3 < minG){
					  minG = num3;
					  MinG = str;
					 
				  }
				  if (num3 > maxG){
					  maxG= num3;
					  MaxG = str;
					 
				  } if (1<= num4 &num4 < minT){
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
	