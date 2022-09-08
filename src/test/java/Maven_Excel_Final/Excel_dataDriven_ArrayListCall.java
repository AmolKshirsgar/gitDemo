package Maven_Excel_Final;

import java.io.IOException;
import java.util.ArrayList;

public class Excel_dataDriven_ArrayListCall 
{

	public static void main(String[] args) throws IOException 
	{
		Excel_dataDrivenDemo_ArrayListFormat d= new Excel_dataDrivenDemo_ArrayListFormat();   //call arrayList method by creating 'd' object
		ArrayList<String> data=d.getData("Add Profile");
		
		System.out.println(data.get(0));  //0th index value =Add Profile
		System.out.println(data.get(1));  //ak
		System.out.println(data.get(2));  //ak18
		System.out.println(data.get(3));  //ak19
		
		// u can use above cell data in selenium as per need
		//driver.findelement(by.id("abc12")).sendKeys(data.get(2))  //ak18 will put in send key

	}

}
