//Sort 0,1,2

import java.util.*;

class Sort012
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sort(a,n);
		for(int x:a)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void sort(int[] a,int n)
	{
		int p0=n-1;
		int p1=0;
		while(true)
		{
			while(p0>=0 && a[p0]!=0)
				p0--;
			while(p1<n && a[p1]==0)
				p1++;
			if(p0<p1)
				break;
			a[p0]=a[p1];
			a[p1]=0;
		}
		int x=p0;
		p0=n-1;
		p1=x+1;
		while(true)
		{
			while(p0>x && a[p0]!=1)
				p0--;
			while(p1<n && a[p1]==1)
				p1++;
			if(p0<p1)
				break;
			a[p0]=a[p1];
			a[p1]=1;
		}
	}
}
		