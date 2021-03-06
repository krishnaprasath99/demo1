package multithreading;

import java.io.*;
import java.util.*;

public class SingleThread2 implements Runnable {
	
	String s="";
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }
	
	@Override
	public void run() 
	{
		Thread t = Thread.currentThread();
		System.out.println("thread is running...");  
		File file = new File(t.getName()+""); 
		  
		  BufferedReader br;
		try 
		{
			br = new BufferedReader(new FileReader(file));
			HashMap<String, Integer> h = new HashMap<>();
			String st; 
			while ((st = br.readLine()) != null)
			{
				String words[]=st.split(" ");  //Split the word using space
		          for (String word : words) 
		          {
		        	  if(h.containsKey(word))
		        	  {
		        		  int val=h.get(word);
		        		  val++;
		        		  h.replace(word,val);
		        	  }
		        	  else
		        	  {
		        		  h.put(word,0);
		        	  }
		          }
			     
			}
			int size=h.size();
			int count=0;
			Map<String, Integer> hm1 = sortByValue(h);
			for (Map.Entry<String, Integer> en : hm1.entrySet()) 
			{
				count++;
				if(count>size-3)
				{
					System.out.println("Key = " + en.getKey() +   ", Value = " + en.getValue()); 
					s=s+en.getKey()+" ";
				}
	        } 
			
			   
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
		  
		
		 
		  
	} 
		
	public String getvalue()
	{
		return s;
	}
	
	public static void main(String[] args) 
	{
		SingleThread2 s1=new SingleThread2(); 
		
		Thread t1 =new Thread(s1,"C:\\Users\\welcome123\\Desktop\\sample1.txt"); 
		
		t1.start(); 
		
		try 
		{
			t1.join();
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		String ans1=s1.getvalue();
		
		
		System.out.println("------------------------");
		System.out.println(ans1);
		
	}

	

}
