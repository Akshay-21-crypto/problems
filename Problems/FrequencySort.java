//Frequency Sort

import java.util.*;

class FrequencySort
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		//Frequency Table
		int[][] f=new int[n][2];
		Arrays.sort(a);
		int i=0,k=-1;
		while(i<n)
		{
			int c=1;
			while((i+1)<n && a[i+1]==a[i])
			{
				c++;
				i++;
			}
			f[++k][0]=a[i];
			f[k][1]=c;
			i++;
		}
		System.out.println("Frequency Table");
		for(int x=0;x<=k;x++)
			System.out.println(f[x][0]+":"+f[x][1]);
		System.out.println();
		partition(f,0,k);
		
		System.out.println("Sorted Frequency Table:");
		for(int x=0;x<=k;x++)
			System.out.println(f[x][0]+":"+f[x][1]);
		System.out.println();
	}
	
	public static void partition(int[][] f,int l,int h)
	{
		if(l<h)
		{
			int x=sort(f,l,h);
			partition(f,l,x-1);
			partition(f,x+1,h);
		}
	}
	
	public static int sort(int[][] f,int l,int h)
	{
		int p=f[h][1];
		int pk=f[h][0];
		int i=l-1;
		for(int j=l;j<h;j++)
		{
			if(f[j][1]<p || (f[j][1]==p && f[j][0]<pk))
			{
				i=i+1;
				int temp=f[i][1];
				f[i][1]=f[j][1];
				f[j][1]=temp;
				temp=f[i][0];
				f[i][0]=f[j][0];
				f[j][0]=temp;
			}
		}
		f[h][1]=f[i+1][1];
		f[i+1][1]=p;
		f[h][0]=f[i+1][0];
		f[i+1][0]=pk;
		return i+1;
	}
			
}
			