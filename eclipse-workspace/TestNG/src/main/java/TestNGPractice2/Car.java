package TestNGPractice2;

import org.testng.annotations.Test;

public class Car {
	private static String ownerName;
	@Test
	public void  runCar(){
		Car obj=new Car();
		 
		int number=obj.getRegistration();
		System.out.println(number);
		
		ownerName = obj.getOwnerName();
		System.out.println(ownerName);
		
		int subTwoNumbers=obj.subTwoNumbers(5,3);
		System.out.println(subTwoNumbers);
		
		int mulThreeNumbers=obj.mulThreeNumbers(2,2,2);
		System.out.println(mulThreeNumbers);
		
		float divTwoNumbers = obj.divTwoNumbers(4,2);
				System.out.println(divTwoNumbers);
		
	}

	public int getRegistration()
	{int registration= 9846;
		return registration;
	}
	private String getOwnerName()
	{String name= "Swathi";
	 return name;
	}
	 void carModel()
	 { System.out.println("Swift");
	 }
	public boolean isPunctured()
	{ 
	return true;
	}
	public int subTwoNumbers(int a,int b)
	{
		return a+b;
	}
    public int mulThreeNumbers(int x, int y, int z)
    { 
    return x*y*z;
    
    }
    public float divTwoNumbers(int g, int h)
    { 
    return g/h;
    }
}
