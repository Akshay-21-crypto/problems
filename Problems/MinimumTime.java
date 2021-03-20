// Minimum time

import java.util.*;

class MinimumTime
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int k=sc.nextInt();
		int min_time=minTime(a,0,k);
		System.out.println(min_time);
		
	}
	
	public static int minTime(int[] a,int i,int w)
	{
		if(w==1)
		{
			int sum=0;
			for(int j=i;j<a.length;j++)
				sum+=a[j];
			return sum;
		}
		
		else
		{
			int t=0;
			int x;
			int min=Integer.MAX_VALUE;
			for(int j=i;j<=(a.length-w);j++)
			{
				t+=a[j];
				x=Math.max(t,minTime(a,j+1,w-1));
				min=Math.min(min,x);
			}
			return min;
		}
	}
}