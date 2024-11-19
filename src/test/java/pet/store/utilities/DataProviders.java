package pet.store.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getAllData(){
		
		String path=System.getProperty("user.dir")+"\\Sample Data\\DataDRivenAPITesting.xlsx";
		ExcelUtility xl=new ExcelUtility();
		xl.ExcelReader(path);
		int rowNumber=xl.getRowCount("Sheet1")-1;
		int columnCount=xl.getColumnCount("Sheet1");
		String apiData[][]=new String[rowNumber][columnCount];
		
		for(int i=1;i<=rowNumber;i++) {
			
			for(int j=0;j<columnCount;j++) {
				apiData[i-1][j]=xl.getCellData("Sheet1", j, i);
			}
		}
		return apiData;
	}
	
	@DataProvider(name="DeleteUser")
	public String[] getUserName() {
		
		String path=System.getProperty("user.dir")+"\\Sample Data\\DataDRivenAPITesting.xlsx";
		ExcelUtility xl=new ExcelUtility();
		xl.ExcelReader(path);
		int rowCount=xl.getRowCount("Sheet1")-1;
	
		String apiData[]=new String[rowCount];
		
		for(int i=1;i<=rowCount;i++) {
			apiData[i-1]=xl.getCellData("Sheet1", 1, i);
		}
		return apiData;
	}

}
