package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{
@Test(invocationCount=0)
	public void Hardassertion() 
{
	System.out.println("a");
	System.out.println("b");
	
	Assert.assertEquals(true, false);
	
	System.out.println("c");
	System.out.println("d");
		
	}
@Test
public void softassertion()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("a");
	System.out.println("b");
	
	sa.assertEquals(0, 1);
	
	System.out.println("c");
	System.out.println("d");
	sa.assertAll();
		
	
}

}
