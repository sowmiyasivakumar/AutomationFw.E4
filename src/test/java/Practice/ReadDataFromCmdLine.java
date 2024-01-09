package Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
@Test
public void data()
{
	String UN = System.getProperty("username");
	String PWD= System.getProperty("password");
	System.out.println(UN);
	System.out.println(PWD);
}
}
