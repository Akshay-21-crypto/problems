//Count Occurances

import java.util.*;

class CountOccurances3
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sort(a,0,n-1);
		
		int[] k=new int[n];
		int[] f=new int[n];
		int p=-1;
		int i=0;
		while(i<n)
		{
			int c=1;
			while((i+1)<n && a[i+1]==a[i])
			{
				c++;
				i++;
			}
			k[++p]=a[i];
			f[p]=c;
			i++;
		}
		int q=sc.nextInt();
		for(int z=0;z<q;z++)
		{
			int x=sc.nextInt();
			int idx=binarySearch(k,p+1,x);
			int cnt;
			if(idx==-1)
				cnt=0;
			else
				cnt=f[idx];
			System.out.println(cnt);
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