package TestNGPractice2;

import org.testng.annotations.Test;

public class OddNumber {
	@Test
public void runOddNumber() {
	for (int i=1;i<20;i++)
	{
		if(i%2!=0)
		{
			System.out.println(i);
		}
	}
}
}
