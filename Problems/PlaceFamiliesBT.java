// Place Families backtracking

import java.util.*;

public class PlaceFamiliesBT
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int k=sc.nextInt();
		int mx_dist=placeFamilies(a,n,k,0);
		System.out.println(mx_dist);
	}
	
	public static int placeFamilies(int[] a,int n,int k,int i)
	{
		if(k==2)
		{
			return a[n-1]-a[i];
		}
		
		int mx_d=Integer.MIN_VALUE;
		for(int j=i+1;j<=(n-k);j++)
		{
			int diff=a[j]-a[i];
			int mx=placeFamilies(a,n,k-1,j);
			int min=Math.min(diff,mx);
			mx_d=Math.max(mx_d,min);
		}
		return mx_d;
	}
}