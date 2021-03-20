//Count Occurances

import java.util.*;

class CountOccurances2
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sort(a,0,n-1);
		
		int q=sc.nextInt();
		for(int i=0;i<q;i++)
		{
			int x=sc.nextInt();
			int p1=binarySearchx(a,n,x,1);
			int p2=binarySearchx(a,n,x,2);
			int c;
			if(p1==-1 && p2==-1)
				c=0;
			else
				c=(p2-p1)+1;
			System.out.println(c);
		}
	}
	
	public static int binarySearchx(int[] a,int n,int k,int x)
	{
		int idx=-1;
		int l=0,h=n-1;
		while(l<=h)
		{
			int m=(l+h)/2;
			if(a[m]==k)
			{
				idx=m;
				if(x==1)
					h=m-1;
				if(x==2)
					l=m+1;
			}
			else if(k>a[m])
				l=m+1;
			else
				h=m-1;
		}
		return idx;
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