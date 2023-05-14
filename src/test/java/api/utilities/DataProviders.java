package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//UserData.xlsx";
		Xlutility xl=new Xlutility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String[rownum][colcount]; // create 2d array
		for(int i=1;i<=rownum;i++) // loop for rowcount
		{
			for(int j=0;j<colcount;j++) // loop for colcount
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j); // store celldata in 2d array
				//i-1 because array index will start from 0
			}
		}
		
		return apidata; // return all the rows and columns from excel sheet
		
	}
	@DataProvider(name="UserNames")//this will return only usernames
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//UserData.xlsx";
		Xlutility xl=new Xlutility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		
		String apidata[]=new String[rownum]; // create 1d array
		for(int i=1;i<=rownum;i++) // loop for rowcount
		{
			
				apidata[i-1]=xl.getCellData("Sheet1", i, 1);
			
		}
		
		return apidata; //
		
	}
	

}
