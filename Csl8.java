package kp;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class Csl8 extends SeleneseTestCase{
	private static final String String = null;
	//Global variables -accessed anywhere in this class
	public String vExp, vInc, vLoan;
	public double vTExp, vTInc, vTLoan;
	public String [][] xData;
	public int xRows, xCols;
	@Before
	public void setUp() throws Exception{
		myprint("Now creating our Selenium object");
		String xPath ="C:/Selenium/Jul5/csl_data.xls";
		//xlRead(xPath);//Reading the excel data
		myprint("XL data read and the rows are "+xRows);
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.chasestudentloans.com/");
		myprint("Now launching Selenium Log and App browser");
		selenium.start();
		
	}

	//private void myprint(java.lang.String string2) {
		// TODO Auto-generated method stub
		
	//}

	private void myprint(java.lang.String string2) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testCsl1() throws Exception{
		String vTui, vFood, vCC;//Declare Expense variables
		String vJob, vGrants;//Declare income variables
		for(int i=1; i<xRows+1; i++){
			myprint("Row# "+i+"being executed");
			//Read from each row in the XL into variables
			vTui = xData[i][1];
			vFood = xData[i][4];//Taking value into a new variable called vTui
			vCC = xData[i][7];
			vJob = xData[i][8];
			vGrants = xdata[i][8];
			vGrants = xData[i][9];
			
			//Simulate the application functionality
			vTExp= Double.parseDouble(vTui)+Double.parseDouble(vFood)+Double.parseDouble(vCC);
			vTInc = Double.parseDouble(vJob)+Double.parseDouble(vGrants);
			vTloan = vTInc-vTExp;
			myprint("Expense total FROM Script is "+ vTExp);
			myprint("Income total FROM Script is " + vTInc);
			myprint("Loan FROM Script is " + vTloan);
		}
		public void xlRead(String spath) throws Exception{
			File myxl =  new File(sPath);
			FileInputStream myStream = new FileInputStream(myxl);
			
			HSSFWorkbook myWB = new HSSFWorkbook(myStream);
			//HSSFSheet mySheet = new HSSFSheet(myWB);
			//HSSFSheet mySheet = myWB.getSheetAt(0);//Referring to 1st sheet
			HSSFSheet mySheet = myWB.getSheetAt(2);//Referring to 3rd sheet
			//int xRows = mySheet.getLastRowNum()+1;
			//int xCols = mySheet.getRow(0).getLastCellNum();
			xRows = mySheet.getLastRowNum()+1;
			xCols = mySheet.getRow(0).getLastCellNum();
			myprint("Rows are "+ xRows);
			myprint("Cols are "+ xCols);
			//String[][] xData = new String[xRows][xCols];
			xData = new String[xRows][xCols];
			for(int i =0; i<xRows; i++){
				HSSFRow row = mySheet.getRow(i);
				for(int j =0; j<xCols; j++){
					HSSFCell cell = row.getCell(j);//To read value from each col in each row
					String value = cellToString(cell);
					xData[i][j] = value;
					System.out.println(value);
					System.out.println("@@@@@");
				}
				System.out.println("");
			}
			
		}
	}
}












