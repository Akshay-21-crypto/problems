import java.util.*;

class FindCode
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String code = sc.nextLine().toUpperCase();
    String[] words = sc.nextLine().toUpperCase().split(":");
    String match="";
    String x="";
    for(int i=0;i<words.length;i++)
    {
      if((x=check(code,words[i]))!="")
	match=match+x+" ";
    }
    if(match=="")
	match="NONE";
    System.out.println(match);
  }

  public static String check(String code, String word)
  {
    int k=code.length();
    int l=word.length();
    int i=0,j=0;
    char ch;
    while(i<k && j<l)
    {
	ch=code.charAt(i);
	if(ch=='?')
        {
	  if(k!=l)
	    i++;
          else{
            i++;
            j++;
	  }
       }
       else
       {
	 if(ch!='_' && ch!=word.charAt(j))
	   return "";
         i++;
	 j++;
       }
    }
    if(i==k && j==l)
	return word;
    return "";
  }
}  