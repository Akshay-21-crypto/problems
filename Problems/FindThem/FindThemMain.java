//Find Them

import java.util.*;

class PuzzleGrid
{
	char[][] grid;
	int size;
	
	PuzzleGrid(int n,char[][] grid){
		size=n;
		this.grid=grid;
	}

	String findIt(String word){
		String loc="";
		int len=word.length();
		String dir="";
		boolean flag=false;
		int i=-1,j=-1,k=-1;
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				if(grid[i][j]==word.charAt(0)){
					int temp_i=i;
					int temp_j=j;
					if(temp_i>=(len-1)){		//North
						for(k=1;k<len && grid[temp_i-k][temp_j]==word.charAt(k);k++);
						if(k==len){
							dir="N";
							flag=true;
							break;
						}
						
						if(((size-1)-temp_j)>=(len-1)){		//NorthEast
							for(k=1;k<len && grid[temp_i-k][temp_j+k]==word.charAt(k);k++);
							if(k==len){
								dir="NE";
								flag=true;
								break;
							}
						}

						if(temp_j>=(len-1)){		//NorthWest
							for(k=1;k<len && grid[temp_i-k][temp_j-k]==word.charAt(k);k++);
							if(k==len){
								dir="NW";
								flag=true;
								break;
							}
						}
	
					}

					if(((size-1)-temp_j)>=(len-1)){		//East
						for(k=1;k<len && grid[temp_i][temp_j+k]==word.charAt(k);k++);
						if(k==len){
							dir="E";
							flag=true;
							break;
						}
					}

					if(temp_j>=(len-1)){		//West
						for(k=1;k<len && grid[temp_i][temp_j-k]==word.charAt(k);k++);
						if(k==len){
							dir="W";
							flag=true;
							break;
						}
					}

					if(((size-1)-temp_i)>=(len-1)){		//South
						for(k=1;k<len && grid[temp_i+k][temp_j]==word.charAt(k);k++);
						if(k==len){
							dir="S";
							flag=true;
							break;
						}
						
						if(((size-1)-temp_j)>=(len-1)){		//SouthEast
							for(k=1;k<len && grid[temp_i+k][temp_j+k]==word.charAt(k);k++);
							if(k==len){
								dir="SE";
								flag=true;
								break;
							}
						}

						if(temp_j>=(len-1)){		//SouthWest
							for(k=1;k<len && grid[temp_i+k][temp_j-k]==word.charAt(k);k++);
							if(k==len){
								dir="SW";
								flag=true;
								break;
							}
						}

					}
				}
			}
			if(flag)
				break;
		}
		loc=String.valueOf(i+1)+" "+String.valueOf(j+1)+" "+dir;
		return loc;
	}

}


class FindThemMain
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of grid");
		int n=sc.nextInt();
		sc.nextLine();
		String[] s=new String[n];
		System.out.println("Enter grid one row at a time");
		for(int i=0;i<n;i++)
			s[i]=sc.nextLine();
		char[][] grid=new char[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				grid[i][j]=s[i].charAt(j);
			}
		}
		PuzzleGrid pg=new PuzzleGrid(n,grid);
		int search;
		while(true){
			System.out.println("1-search; 0-exit");
			search=sc.nextInt();
			sc.nextLine();
			switch(search){
				case 1 : 	System.out.println("Enter word to search");
						String word=sc.nextLine();
						String loc =  pg.findIt(word);
						System.out.println("Look at "+loc);
						break;
				case 0 :	System.exit(0);
				default :	System.exit(0);
			}
		}
	}
}