package UtilityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	XSSFWorkbook workbook;

	public ExcelData() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/test/resources/Testdata/MMBData.xlsx");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getStringMMBData(String Sheetname, int Row, int column) {
		XSSFCell cell = workbook.getSheet(Sheetname).getRow(Row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}
	public XSSFCell getStringMMBData(int Sheetindex, int Row, int column) {
		return workbook.getSheetAt(Sheetindex).getRow(Row).getCell(column);
		//DataFormatter dataFormatter = new DataFormatter();
		//String data = dataFormatter.format(cell);
		
		
	}
	
	public String getPaymentMMBData(String Sheetname, int Row, int column) {
		XSSFCell cell = workbook.getSheet(Sheetname).getRow(Row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}
	public String getBillingMMBData(String Sheetname, int Row, int column) {
		XSSFCell cell = workbook.getSheet(Sheetname).getRow(Row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}

}
