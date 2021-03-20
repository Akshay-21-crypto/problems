//Count Occurances

import java.util.*;

class CountOccurances4
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
		int[] qrs=new int[q];
		int[] tqrs=new int[q];
		for(int i=0;i<q;i++)
		{
			int x=sc.nextInt();
			qrs[i]=x;
			tqrs[i]=x;
		}
		sort(tqrs,0,q-1);
		int[] cnt=new int[q];
		count(a,n,tqrs,q,cnt);
		for(int i=0;i<q;i++)
		{
			int idx=binarySearch(tqrs,q,qrs[i]);
			int c=cnt[idx];
			System.out.println(c);
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
	
	public static void count(int[] a,int n,int[] tqrs,int q,int[] cnt)
	{
		int p1=0,p2=0;
		while(p1<n && p2<q)
		{
			if(p2>0 && tqrs[p2]==tqrs[p2-1])
				cnt[p2]=cnt[p2-1];
			else
			{
				int c=0;
				while(p1<n && tqrs[p2]>a[p1])
					p1++;
				while(p1<n && tqrs[p2]==a[p1])
				{
					c++;
					p1++;
				}
				cnt[p2]=c;
			}
			p2++;
		}
		while(p2<q)
		{
			if(p2>0 && tqrs[p2]==tqrs[p2-1])
				cnt[p2]=cnt[p2-1];
			else
				cnt[p2]=0;
			p2++;
		}		
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