//Count Occurances

import java.util.*;

class CountOccurances1
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sort(a,0,n-1);
		/*for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();*/
		int q=sc.nextInt();
		for(int i=0;i<q;i++)
		{
			int x=sc.nextInt();
			int c=0;
			int idx=binarySearch(a,n,x);
			if(idx!=-1)
			{
				int tidx=idx;
				while(tidx>=0 && a[tidx--]==x)
					c++;
				tidx=idx+1;
				while(tidx<n && a[tidx++]==x)
					c++;
			}
			System.out.println(x+":"+c);
		}
			
	}
	
	public static int binarySearch(int[] a,int n,int x)
	{
		int l=0,h=n-1;
		while(l<=h)
		{
			int mid=(l+h)/2;
			if(a[mid]==x)
				return mid;
			else if(x>a[mid])
				l=mid+1;
			else
				h=mid-1;
		}
		return -1;
	}
	
	public static void sort(int[] a,int l,int h)
	{
		if(l>=h)
			return;
		int mid=(l+h)/2;
		sort(a,l,mid);
		sort(a,mid+1,h);
		merge(a,l,mid,h);
	}
	
	public static void merge(int[] a,int l,int m,int h)
	{
		int i=l;
		int j=m+1;
		int[] temp=new int[h-l+1];
		int k=-1;
		while(i<=m && j<=h)
		{
			if(a[i]<a[j])
				temp[++k]=a[i++];
			else
				temp[++k]=a[j++];
		}
		while(i<=m)
			temp[++k]=a[i++];
		while(j<=h)
			temp[++k]=a[j++];
		for(int x=l;x<=h;x++)
			a[x]=temp[x-l];
	}
}