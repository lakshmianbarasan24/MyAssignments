package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SalesForceDataProvider {

	@DataProvider(name = "getLegalEntityNames")
	public String[][] getLegalEntityNames() throws IOException {
		// Step1: Settingup the excel file / workBook
		XSSFWorkbook wb = new XSSFWorkbook("./ReadExcel/LegalEntityNames.xlsx");

		// Step2: to get the sheet from the wb
		XSSFSheet sheet = wb.getSheetAt(0);

		// getLastRowNum(); - excludes the Header
		int lastRowNum = sheet.getLastRowNum();

		short lastCellNum = sheet.getRow(2).getLastCellNum();
	
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
		return data;
	}
}
