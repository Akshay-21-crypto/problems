//Interleavings

import java.util.*;

class Interleavings
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		
		interleavings(s1,s2,0,0,"");
	}
	
	public static void interleavings(String s1,String s2,int i,int j,String res)
	{
		int l1=s1.length();
		int l2=s2.length();
		if(i==l1 && j==l2)
		{
			System.out.println(res);
			return;
		}
		else if(j==l2)
		{
			interleavings(s1,s2,i+1,j,res+=String.valueOf(s1.charAt(i)));
		}
		else if(i==l1)
		{
			interleavings(s1,s2,i,j+1,res+=String.valueOf(s2.charAt(j)));
		}
		else
		{
			if(s1.charAt(i)<s2.charAt(j))
			{
				String temp=res;
				temp+=String.valueOf(s1.charAt(i));
				interleavings(s1,s2,i+1,j,temp);
				temp=res;
				temp+=String.valueOf(s2.charAt(j));
				interleavings(s1,s2,i,j+1,temp);
			}
			else if(s2.charAt(j)<s1.charAt(i))
			{
				String temp=res;
				temp+=String.valueOf(s2.charAt(j));
				interleavings(s1,s2,i,j+1,temp);
				temp=res;
				temp+=String.valueOf(s1.charAt(i));
				interleavings(s1,s2,i+1,j,temp);
			}
		}
	}

}
		