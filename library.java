import java.util.Arrays;
import java.util.*;
public class HASHCODE {
  
	
	// this hashmap will help us to compare the ratio of individual library by providing current score
	 
	static HashMap<Integer,Integer> map=new HashMap<>();
	
	// this will calculate the final score which we have to print
    
	static int final_score=0;
	
	// this will help us to consider library which will contribute to our score
	 
	static class proceed
	{
		int at_day;
	info showdown;
	}
	 
	// info of each library
	
	static class info
	{
		static int books;
		static int sign_up;
		static int book_scan;
		static ArrayList<Integer> book_ctn=new ArrayList<>();
		public static Object info;	
	}
	
	// main method
	 
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		int n_books=sc.nextInt();
		int n_lib=sc.nextInt();
		int n_days=sc.nextInt();
	
		// score of different books available
		
		int score_books[]=new int[n_books];
	for(int i=0;i<n_books;i++)
	{
		score_books[i]=sc.nextInt();
	}
	
	// this arrayList will contain info of each library
	
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
	
	
	ArrayList<proceed> warm_up=new ArrayList<>();
	ArrayList<info> final_showdown=new ArrayList<>();
	info lib_out=null;
	
	// this will help us for the sign up process
	int count_old=0;
	int count_new=0;

	// this will help us to maintain how many libs we have considerd till now
	
	int lib_count=0;
	
	
	while(count_new<n_days-1||lib_count>=n_lib)
{
	
if(warm_up.isEmpty())
{
	 lib_out=compare(lib_info,n_days,count_old);
	proceed p=new proceed();
	p.at_day=lib_out.sign_up;
	p.showdown=lib_out;
warm_up.add(p);	

count_new=p.at_day;
lib_count++;
update_map(lib_out);
}
if(count_old<count_new)
{
	while(count_old<count_new)
	{
		count_old++;
	}
}
lib_out=compare(lib_info,n_days,count_old);
count_new+=lib_out.sign_up;
proceed p=new proceed();
p.at_day=count_new;
p.showdown=lib_out;
warm_up.add(p);
lib_count++;
update_map(lib_out);
}
	
// calculating the final score
	
	for(int i=0;i<warm_up.size();i++)
	{
		contribute(warm_up.get(i),n_days);
	}
	
	// printing the final score
	
	System.out.println(final_score);
	
	}
	
	// this function will help us to compare different library
	
	public static info compare(ArrayList<info> lib_info,int n_days,int count_old)
{
	double max_ratio=Double.MIN_VALUE;
	info lib_idx=null;
for(int i=0;i<lib_info.size();i++)
{
	int effct_score=0;
	for(int j=0;j<lib_info.get(i).book_ctn.size();j++)
	{
	if(map.containsKey(lib_info.get(i).book_ctn.get(j))==false) {
	
		effct_score+=lib_info.get(i).book_ctn.get(j);	
	}

	}
	double current_ratio=(lib_info.get(i).book_scan+effct_score-lib_info.get(i).sign_up)/lib_info.get(i).sign_up;
	double max=Math.max(max_ratio,current_ratio);
if(max>max_ratio&&lib_info.get(i).sign_up<n_days-count_old)
{
	max_ratio=max;
	lib_idx=lib_info.get(i);
}
}
return lib_idx;

}
	
	// calculating contribution of each library in the final score
	
	public static void contribute(proceed lib,int n_days)
	{
		int books_left=0;
		int days_left=n_days-lib.at_day;
		while(books_left<lib.showdown.book_ctn.size()&&days_left<n_days)
		{
			 final_score+=lib.showdown.book_ctn.get(books_left);
		}

	}
	
	// updating the hashmap
	
public static void update_map(info lib_out)
{
	int i=0;
	while(i<lib_out.book_ctn.size())
	{
		if((map.containsKey(lib_out.book_ctn.get(i)))==false)
		{
			map.put(lib_out.book_ctn.get(i),1);
		}
	}
}

}
