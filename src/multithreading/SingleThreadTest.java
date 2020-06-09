package multithreading;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleThreadTest {

	@Test
	void test() {

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
		
		assertEquals("b y z ",ans1);
	}

}
