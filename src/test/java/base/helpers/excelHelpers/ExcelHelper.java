package base.helpers.excelHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	
	
	public static FileInputStream fis = null;
    public static XSSFWorkbook workbook = null;
    public static XSSFSheet sheet = null;
    public static XSSFRow row = null;
    public XSSFCell cell = null;
 
    public static FileInputStream startExcelInstance(String xlFilePath)
    {
        try {
			fis = new FileInputStream(xlFilePath);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
        try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return fis;
    }
    
    public static void endExcelInstance() {
        try {
    	fis.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
    }
 
    public static Map<String, String> ReadLocalizationValues(String xlFilePath, String sheetName, String colName)
    {
    	startExcelInstance(xlFilePath);
    	
    	
    	Map<String, String> LanguageDictionary = new HashMap<String, String>();
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                String actualColumnName = row.getCell(i).getStringCellValue().trim();
            	
            	if(actualColumnName.equals(colName))
            	{
                    col_Num = i;
            	}
            }
 
            Iterator<Row> rowIterator = sheet.iterator();
            
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                //System.out.println(row.getRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                      Cell cell = cellIterator.next();
                      if(row.getRowNum() > 0){ //To filter column headings
                        if(cell.getColumnIndex() == col_Num){// To match column index
                        	LanguageDictionary.put(row.getCell(0).getStringCellValue().trim(), cell.getStringCellValue());
                        }
                    }
                }
            }

            }

        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("column "+ colName +" does not exist  in Excel");
            endExcelInstance();
        }
        
        
		return LanguageDictionary;
    }
	
	
}
