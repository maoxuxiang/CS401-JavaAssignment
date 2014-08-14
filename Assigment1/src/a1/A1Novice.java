package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		System.out.println("input:");
		Scanner s = new Scanner(System.in);
		
        process(s);
		// TODO Auto-generated method stub
        
	}
	public static void process(Scanner s) {
		//store the input into a string
		String str = s.next();    
		// int for storing the times
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		// when input is end, it ends. 
		  while (!str.equals("end")){  
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
				
				// change the str to next string
				str = s.next();
				
			}
		  System.out.println("A count:" + num1);
		  System.out.println("C count:" + num2);
		  System.out.println("G count:" + num3);
		  System.out.println("T count:" + num4);
		  //close scanner
		  s.close();
		
    }
}
	