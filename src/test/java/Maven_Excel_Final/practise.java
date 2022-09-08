package Maven_Excel_Final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practise 
{

	
	public static void main(String[] args) throws IOException 
	{	
		FileInputStream fis = new FileInputStream("G://AK Study//Excel demoData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				Iterator<Row> rows=sheet.rowIterator();
				Row firstRow=rows.next();
				
				int k=0;
				int column=0;
				Iterator<Cell> ce=firstRow.cellIterator();
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("data2"))
					{
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				while(rows.hasNext())
				{
					Row cellRow=rows.next();
					if(cellRow.getCell(column).getStringCellValue().equalsIgnoreCase("Add Profile"))
					{
						Iterator<Cell> cellValue=cellRow.iterator();
						while(cellValue.hasNext())
						{
							System.out.println(cellValue.next().getStringCellValue());
						}
					}
				}
			}
		}
	
	}
	
		
		
		

}


