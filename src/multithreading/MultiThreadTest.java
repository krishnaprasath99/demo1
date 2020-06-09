package multithreading;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiThreadTest {

	@Test
	void test() {
		MultiThread s1=new MultiThread(); 
		MultiThread s2=new MultiThread(); 
		MultiThread s3=new MultiThread(); 
		Thread t1 =new Thread(s1,"C:\\Users\\welcome123\\Desktop\\sample1.txt"); 
		Thread t2 =new Thread(s2,"C:\\Users\\welcome123\\Desktop\\sample2.txt");
		Thread t3 =new Thread(s3,"C:\\Users\\welcome123\\Desktop\\sample3.txt");
		t1.start(); 
		t2.start(); 
		t3.start();
		try 
		{
			t1.join();
			t2.join();
			t3.join();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		String ans1=s1.getvalue();
		String ans2=s2.getvalue();
		String ans3=s3.getvalue();
		
		System.out.println("------------------------");
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		
		assertEquals("b y z ",ans1);
		assertEquals("z l hello ",ans2);
		assertEquals("f a b ",ans3);
	}

}
