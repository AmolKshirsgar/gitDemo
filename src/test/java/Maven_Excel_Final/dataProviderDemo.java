package Maven_Excel_Final;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderDemo 

{
	@Test(dataProvider="testData")
	public void dataDrivenTest(String msg, String name,int id)
	{
		System.out.println(msg + name+ id);
	}
	
	@DataProvider(name="testData")
	public Object[][] getData()
	{
		//Object[][] data={{rray1},{array2},{array3}}
		Object[][] data= {{"hi","Amol",18},{"hello","AK",19},{"come","AK1819",1819}};
		return data;
	}

}
