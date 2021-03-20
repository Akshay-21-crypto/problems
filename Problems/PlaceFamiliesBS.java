// Placing Families BinarySearch

import java.util.*;

class PlaceFamiliesBS
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int k=sc.nextInt();
		int mx_dist=placeFamilies(a,n,k);
		System.out.println(mx_dist);
	}
	
	public static int placeFamilies(int[] a,int n,int k)
	{
		int l=0,h=a[n-1]-a[0];
		int ans=-1;
		while(l<=h)
		{
			int m=(l+h)/2;
			if(valid(a,n,k,m))
			{
				ans=m;
				l=m+1;
			}
			else
				h=m-1;
		}
		return ans;
	}
	
	public static boolean valid(int[] a,int n,int k,int m)
	{
		int placed=1;
		int i=0;
		while(i<n && placed<k)
		{
			int x=a[i];
			while(i<n && (a[i]-x)<m)
			{
				i++;
			}
			if(i<n)
				placed++;
		}
		if(placed==k)
			return true;
		return false;
	}
}