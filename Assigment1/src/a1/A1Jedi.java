package a1;

import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;


public class A1Jedi {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        process(s);
		// TODO Auto-generated method stub

	}
	
	public static void process(Scanner s) {
		int a = s.nextInt();
		//store pattern in to a string array
		String[] pattern = new String[a];
		for (int i=0;i<pattern.length;i++){
			String patterns = s.next();
			pattern[i] = patterns;
		}
		// initialize a Arraylist and store the next string into it
		ArrayList al=new ArrayList();
		
		while (true){
		String str = s.next();
		
		if (str.equals("end")){
			for (int i=0; i<a;i++){
				// call method findstr2
		System.out.println("Pattern " + pattern[i]+" Count:"+findstr2(al, pattern[i]));
			}
			break;
		}
		else al.add(str);
		}
		
		
		
			
		}
	
	//create a method used for count how many times a pattern occurred
	public static int findstr2(ArrayList srctext, String keyword){
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(srctext);
		String str = sb.toString();
		Pattern p = Pattern.compile(keyword);
		Matcher m = p.matcher(str);
		while(m.find()){
			count++;
		}
		
		return count;
	}
}
	
	
