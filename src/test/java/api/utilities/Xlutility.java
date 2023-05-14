package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlutility{
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public Xlutility(String path)
	{ 
		this.path=path;
	}
	 public int getRowCount(String Sheetname)throws IOException
	 {
		 
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(Sheetname);
		 int rowcount=sheet.getLastRowNum();
		 workbook.close();
		 fi.close();
		 return rowcount;
	 }
	 public int getCellCount(String sheetname,int rownum)throws IOException
	 {
		 
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetname);
		 row=sheet.getRow(rownum);
		 int cellcount=row.getLastCellNum();
		 workbook.close();
		 fi.close();
		 return cellcount;
	 }
	 public String getCellData(String sheetname,int rownum,int colnum)throws IOException
	 {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetname);
		 row=sheet.getRow(rownum);
		 cell=row.getCell(colnum);
		 

/*DataFormatter contains methods for formatting the value stored in aCell. 
This can be useful for reports and GUI presentations when you need to display data exactly as 
it appears in Excel. */

		 DataFormatter formatter=new DataFormatter();
		 String data;
		 try {
			 data=formatter.formatCellValue(cell); //Returns the formatted value of a cell
			 }
		 catch(Exception e)
		 { 
			 data="";
		 }
		 workbook.close();
		 fi.close();
		return data;
		 
	 }
	 
	 
	 
	 
	 
	
	
	
		
		
	}

