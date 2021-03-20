//Smaller elements to Right

import java.util.*;

class SmallerToRight
{
	static int ans=0;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		partition(a,0,n-1);
		//System.out.println();
		System.out.println(ans);
	}
	
	public static void partition(int[] a,int l,int h)
	{
		if(l>=h)
			return;
		int m=(l+h)/2;
		partition(a,l,m);
		partition(a,m+1,h);
		int k=merge(a,l,m,h);
		ans+=k;
		//System.out.print(k+" ");
	}
	
	public static int merge(int[] a,int l,int m,int h)
	{
		int i=l;
		int j=m+1;
		int c=0;
		int k=-1;
		int[] temp=new int[h-l+1];
		
		while(i<=m && j<=h)
		{
			if(a[i]>a[j])
			{
				c+=(m-i+1);
				temp[++k]=a[j++];
			}
			else
			{
				temp[++k]=a[i++];
			}
		}
		while(i<=m)
			temp[++k]=a[i++];
		while(j<=h)
			temp[++k]=a[j++];
		for(int x=l;x<=h;x++)
			a[x]=temp[x-l];
		return c;
	}
}