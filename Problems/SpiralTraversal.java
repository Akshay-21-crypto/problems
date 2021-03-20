import java.util.*;

class SpiralTraversal
{
 public static void main(String[] args)
 {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter size of square matrix");
   int n = sc.nextInt();
   int[][] a=new int[n][n];

   for(int x=0;x<n;x++)
	for(int y=0;y<n;y++)
		a[x][y]=sc.nextInt();

   int r=n,c=n;
   int i=0,j=0;
   int d=-1;
   while(r!=0 && c!=0)
   {
     d=(d+1)%4;
     switch(d){
	case 0:for(int k=1;k<=c;k++){
		System.out.print(a[i][j]+" ");
		j++;
	       }
	       j--;i++;r--;break;
	case 1:for(int k=1;k<=r;k++){
		System.out.print(a[i][j]+" ");
		i++;
	       }
	       i--;j--;c--;break;
	case 2:for(int k=1;k<=c;k++){
		System.out.print(a[i][j]+" ");
		j--;
	       }
	       j++;i--;r--;break;
	case 3:for(int k=1;k<=r;k++){
		System.out.print(a[i][j]+" ");
		i--;
	       }
	       i++;j++;c--;break;
    }
   }
   System.out.println();
 }
}