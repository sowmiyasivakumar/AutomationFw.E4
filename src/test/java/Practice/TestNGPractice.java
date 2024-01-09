package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice
{
	@Test
	public void createcontact()
	{
		Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods="createcontact")
	public void deletecontact()
	{
		System.out.println("delete");
	}
	@Test(invocationCount=2)
	public void modifycontact()
	{
		System.out.println("modify");
	}

}
