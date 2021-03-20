//QuickSort

import java.util.*;

class QuickSort
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		partition(a,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void partition(int[] a,int l,int h)
	{
		if(l<h)
		{
			int x=quicksort(a,l,h);
			partition(a,l,x-1);
			partition(a,x+1,h);
		}
	}
	
	public static int quicksort(int[] a,int l,int h)
	{
		int p=a[h];
		int i=l-1;
		for(int j=l;j<h;j++)
		{
			if(a[j]<=p)
			{
				i=i+1;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		a[h]=a[i+1];
		a[i+1]=p;
		return i+1;
	}
}