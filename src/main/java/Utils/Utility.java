package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {	

	public static WebDriver driver;


	public String excelSheetData(String sheetName,int rowNo,int cellNo) throws IOException {
		String path= "src/main/resources/TestCases.xlsx";
		FileInputStream file= new FileInputStream(path);
		Workbook book= WorkbookFactory.create(file);
		Sheet sheet= book.getSheet(sheetName);
		Row row= sheet.getRow(rowNo);
		Cell cell=row.getCell(cellNo);

		String excelData;
		try {
			excelData=cell.getStringCellValue();
		}
		catch(IllegalStateException e) {
			double value=cell.getNumericCellValue();
			//System.out.println(value);
			//excelData=String.valueOf(value);
			excelData=Double.toString(value);

		}
		return excelData;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
	
	public static void captureScreenshot(WebDriver driver,String testID) throws IOException {			
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
//		Date date=new Date();
//		String FileName = date.toString().replace(" ","_").replace(":", " ") ;
		String FileName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());	
		
		File dest= new File("test-output\\FailedScreeshots\\Test"+testID+" "+FileName+".jpg");
		FileHandler.copy(src,dest );			
	}

}
