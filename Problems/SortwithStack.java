//Sort with Stack

import java.util.*;

class Stack
{
	int[] ar;
	int n;
	int top;
	Stack(int[] ar,int n)
	{
		this.ar=ar;
		this.n=n;
		this.top=-1;
	}
	boolean isFull()
	{
		return top==(n-1);
	}
	boolean isEmpty()
	{
		return top==-1;
	}
	void push(int x)
	{
		if(!isFull())
		{
			ar[++top]=x;
		}
	}
	int pop()
	{
		int x=Integer.MIN_VALUE;
		if(!isEmpty())
		{
			x=ar[top];
			top--;
		}
		return x;
	}
}

class SortwithStack
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int[] sorted=sort(a,n);
		for(int x:sorted)
			System.out.print(x+"  ");
		System.out.println();
	}
	
	public static int[] sort(int[] a,int n)
	{
		Stack temp=new Stack(a,n);
		Stack st=new Stack(new int[n],n);
		for(int i=0;i<n;i++)
		{
			st.push(Integer.MAX_VALUE);
			temp.top=n-1;
			int idx=-1;
			while(temp.top!=-1)
			{
				if(temp.ar[temp.top]<=st.ar[st.top])
				{
					st.ar[st.top]=temp.ar[temp.top];
					idx=temp.top;
				}
				temp.top--;
			}
			temp.ar[idx]=Integer.MAX_VALUE;
		}
		return st.ar;
	}
}
			