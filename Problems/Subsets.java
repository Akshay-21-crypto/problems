//lexicographical subsets

import java.util.*;

class Subsets
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] ar=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		System.out.println("SUBSETS: ");
		subsets(ar,0,"");
	}
	
	public static void subsets(int[] ar,int i,String s)
	{
		if(i>=ar.length)
			return;
		for(int j=i;j<ar.length;j++)
		{
			String temp=s;
			temp=temp+String.valueOf(ar[j])+" ";
			System.out.println(temp);
			subsets(ar,j+1,temp);
		}
	}
}
			