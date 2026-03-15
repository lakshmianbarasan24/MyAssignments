package marathon.SalesforceTestNg;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String[][] getExcelData(String fileName) throws IOException {
		// Step1: Settingup the excel file / workBook

		XSSFWorkbook wb = new XSSFWorkbook("./ReadExcel/"+fileName+".xlsx");

		// Step2: to get the sheet from the wb
		XSSFSheet sheet = wb.getSheetAt(0);

		// getLastRowNum(); - excludes the Header
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		short lastCellNum = sheet.getRow(1).getLastCellNum();
	 System.out.println(lastCellNum);
		String[][] data = new String[lastRowNum][lastCellNum];
		
		// OuterLoop is for rows
		for (int i = 1; i <= lastRowNum; i++) {

			// InnerLoop is for cell/Column
			for (int j = 0; j < lastCellNum; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = stringCellValue;
				System.out.println(stringCellValue);
			}

		}
		wb.close();
		return data;
		
	}
}
