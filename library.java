import java.util.Arrays;
import java.util.*;
public class HASHCODE {
	static int count_days=0;
	static int ping=0;
	static class info
	{
		static int books;
		static int sign_up;
		static int book_scan;
		static ArrayList<Integer> book_ctn=new ArrayList<>();
		public static Object info;	
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n_books=sc.nextInt();
		int n_lib=sc.nextInt();
		int n_days=sc.nextInt();
	int score_books[]=new int[n_books];
	for(int i=0;i<n_books;i++)
	{
		score_books[i]=sc.nextInt();
	}
	ArrayList<info> lib_info=new ArrayList<>();
	for(int i=0;i<n_lib;i++)
	{
		info t=new info();
		t.books=sc.nextInt();
		t.sign_up=sc.nextInt();
		t.book_scan=sc.nextInt();
		for(int j=0;j<t.books;j++)
		{
			t.book_ctn.add(sc.nextInt());
		
	}
		lib_info.add(t);
	}
	// yahan se solution chaalu hoga, figuring it out.
HashMap<Integer,Integer> map=new HashMap<>();
while(count_days<n_days)
{
if(ping==0)
{
	int consider_lib=compare(lib_info);
}

}
	
	}
}

