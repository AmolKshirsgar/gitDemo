package Maven_Excel_Final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_dataDrivenDemo 
{

	public static void main(String[] args) throws IOException 
	{
		//this is coome code prerequisite of all excel code till we get acess of sheet
		
		FileInputStream fis = new FileInputStream("G://AK Study//Excel demoData.xlsx");  //fis is object which store path of excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);   //with workbook object we are hetting acces of excel path with help of fis object
		
		int sheets=workbook.getNumberOfSheets();  // this will give you number of sheets avail in excel
		System.out.println("Number of sheets in excel are: "+sheets);
		
		
		// Actions: 1.Identify"TestCases" 'column' by scanning entire 1st row
		//2. once column identify, scan entire "TestCases" column and identify "Purchase" test case 'row'
		//3. once you grab "Purchase" test case row, then pull all data of that row and feed into test
		
		
		//we have to iterate through each sheets of workbook to get specific named sheet we are looking with help for loop
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) 
				
			{
				XSSFSheet sheet=workbook.getSheetAt(i);  //if sheet name of workbook is desired then store that shhet in sheet object of XSSFShhet

				//sheet is collection of all rows
				Iterator<Row> rows=sheet.rowIterator();  //with help of iterator we can go to sheet to get access of all rows
				Row firstRow=rows.next();  //with help of next() we can get access of first row 
				
				//Row is colletion of cells
				Iterator<Cell> ce=firstRow.cellIterator();  //with this step we can get access of each cell of that first row so that we can get desired column
				
				int k=0;
				int column = 0;
				
				while (ce.hasNext())
				{
					Cell value=ce.next();  //once we get cell iterator we have to go each cell with hasNect() and get values with ce.next().
					if(value.getStringCellValue().equalsIgnoreCase("Test Cases")) //once we get all cells we have to find desired cell which is our expected column
					{
						column=k;  //initilizing k and column will give you exact coulmn index
					}
					k++;
				}
				
				System.out.println("Expected desired column to retrieve data is:"+column);
				
				//2. once column identify, scan entire "TestCases" column and identify "Purchase" test case 'row'
				while(rows.hasNext())
				{
					Row cr=rows.next();
					if(cr.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
					{
						//3. once you grab "Purchase" test case row, then pull all data of that row and feed into test
						Iterator<Cell> cvalue=cr.iterator();
						while(cvalue.hasNext())
						{
							System.out.println(cvalue.next().getStringCellValue());
							
						}
						
						
					}
				}
			
			}
		}

		
		

	}

}
