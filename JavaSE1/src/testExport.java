import java.io.*;
import java.util.*;
// import java.text.*;
// import java.math.*;
// import javax.servlet.http.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class testExport {
    public testExport() throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row = sheet.createRow(0);
        row.createCell(2).setCellValue("aaa");
        row.createCell(0).setCellValue(new Date());
        wb.setSheetName(0, "aaaa");

        FileOutputStream fos = new FileOutputStream("D:/aaaaa" + ".xls");
        wb.write(fos);
        fos.close();
        wb.close();
    }

    public static void main(String[] args) {
        try {
            new testExport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
