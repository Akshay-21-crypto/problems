//Search in a Bitonic Array

import java.util.*;

class BitonicSearch
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int k=sc.nextInt();
		int idx=searchPivot(a,n);
		int i1=binarySearch(a,0,idx,k,1);
		if(i1==-1)
			i1=binarySearch(a,idx,n-1,k,-1);
		System.out.println(i1);
	}
	
	public static int searchPivot(int[] a,int n)
	{
		int p=-1;
		int l=0,h=n-1;
		while(l<=h)
		{
			int m=(l+h)/2;
			if(m==0)
			{
				if(a[m]>a[m+1])
				{
					p=m;
					break;
				}
				else
					l=m+1;
			}
			else if(m==n-1)
			{
				if(a[m]>a[m-1])
				{
					p=m;
					break;
				}
				else
					h=m-1;
			}
			else if(a[m-1]<a[m] && a[m]>a[m+1])
			{
				p=m;
				break;
			}
			else
			{
				if(a[m-1]>a[m])
					h=m-1;
				else if(a[m+1]>a[m])
					l=m+1;
			}
		}
		return p;
	}
	
	public static int binarySearch(int[] a,int l,int h,int k,int x)
	{
		while(l<=h)
		{
			int m=(l+h)/2;
			if(a[m]==k)
				return m;
			else if(k>a[m])
			{
				if(x==1)
					l=m+1;
				else if(x==-1)
					h=m-1;
			}
			else
			{
				if(x==1)
					h=m-1;
				else if(x==-1)
					l=m+1;
			}
		}
		return -1;
	}
}