//wap to to get data from excdel as dataProvider concept

package Maven_Excel_Final;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider_ExcelHandle 

{
	DataFormatter formatter=new DataFormatter();   //it will conver any values from array into string
	
	@Test(dataProvider="testData")
	public void dataDrivenTest(String msg, String name,int id)
	{
		System.out.println(msg + name+ id);
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() throws IOException
	{
		//Object[][] data= {{"hi","Amol",18},{"hello","AK",19},{"come","AK1819",1819}};
		//return data;	
		
		FileInputStream fis=new FileInputStream("G://AK Study//Excel demoData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheetAt(1);  //will provide sheet of workbook
		int rowCount=sheet.getPhysicalNumberOfRows();  //will providenum of rows in sheet
		XSSFRow row=sheet.getRow(0);  //will provide access to 0th row
		
		int colCount=row.getLastCellNum();  //by rows last cell you can get column count
		
		Object data[][]=new Object[rowCount-1][colCount];  //create arrya with row and coulmn count
		for(int i=0;i<rowCount-1;i++)
		{
			System.out.println("Outer Loop Started here");
			row=sheet.getRow(i+1);
			
			for(int j=0;j<colCount;j++)
			{
				XSSFCell cell=row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
			}
			
			System.out.println("*******************");
			System.out.println("Outer loop ended here");
		}
		return data;
	}

}
