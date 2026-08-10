package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;

    String path;

    // Constructor
    public XLUtility(String path) {
        this.path = path;
    }

    // Get row count
    public int getRowCount(String sheetName) throws IOException {

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Sheet '" + sheetName + "' does not exist.");
        }

        int rowcount = sheet.getLastRowNum();

        workbook.close();
        fi.close();

        return rowcount;
    }

    // Get cell count
    public int getCellCount(String sheetName, int rownum)
            throws IOException {

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Sheet '" + sheetName + "' does not exist.");
        }

        row = sheet.getRow(rownum);

        if (row == null) {
            workbook.close();
            fi.close();
            return 0;
        }

        int cellcount = row.getLastCellNum();

        workbook.close();
        fi.close();

        return cellcount;
    }

    // Get cell data
    public String getCellData(String sheetName, int rownum, int colnum)
            throws IOException {

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Sheet '" + sheetName + "' does not exist.");
        }

        row = sheet.getRow(rownum);

        if (row == null) {
            workbook.close();
            fi.close();
            return "";
        }

        cell = row.getCell(colnum);

        if (cell == null) {
            workbook.close();
            fi.close();
            return "";
        }

        DataFormatter formatter = new DataFormatter();

        String data;

        try {
            data = formatter.formatCellValue(cell);
        }
        catch (Exception e) {
            data = "";
        }

        workbook.close();
        fi.close();

        return data;
    }

    // Set cell data
    public void setCellData(String sheetName, int rownum,
                            int colnum, String data)
            throws IOException {

        File xlfile = new File(path);

        // If file does not exist, create a new workbook
        if (!xlfile.exists()) {

            workbook = new XSSFWorkbook();

            sheet = workbook.createSheet(sheetName);

            row = sheet.createRow(rownum);

            cell = row.createCell(colnum);

            cell.setCellValue(data);

            fo = new FileOutputStream(path);

            workbook.write(fo);

            workbook.close();
            fo.close();

            return;
        }

        // Open existing workbook
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        // Create sheet if it doesn't exist
        if (workbook.getSheetIndex(sheetName) == -1) {
            workbook.createSheet(sheetName);
        }

        sheet = workbook.getSheet(sheetName);

        // Create row if it doesn't exist
        if (sheet.getRow(rownum) == null) {
            sheet.createRow(rownum);
        }

        row = sheet.getRow(rownum);

        // Create cell
        cell = row.createCell(colnum);

        cell.setCellValue(data);

        // Write changes
        fo = new FileOutputStream(path);

        workbook.write(fo);

        workbook.close();
        fi.close();
        fo.close();
    }

    // Fill cell with GREEN color
    public void fillGreenColor(String sheetName, int rownum,
                               int colnum)
            throws IOException {

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Sheet '" + sheetName + "' does not exist.");
        }

        row = sheet.getRow(rownum);

        if (row == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Row " + rownum + " does not exist.");
        }

        cell = row.getCell(colnum);

        if (cell == null) {
            cell = row.createCell(colnum);
        }

        style = workbook.createCellStyle();

        style.setFillForegroundColor(
                IndexedColors.GREEN.getIndex());

        style.setFillPattern(
                FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        // IMPORTANT: Create FileOutputStream before writing
        fo = new FileOutputStream(path);

        workbook.write(fo);

        workbook.close();
        fi.close();
        fo.close();
    }

    // Fill cell with RED color
    public void fillRedColor(String sheetName, int rownum,
                             int colnum)
            throws IOException {

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Sheet '" + sheetName + "' does not exist.");
        }

        row = sheet.getRow(rownum);

        if (row == null) {
            workbook.close();
            fi.close();
            throw new IllegalArgumentException(
                    "Row " + rownum + " does not exist.");
        }

        cell = row.getCell(colnum);

        if (cell == null) {
            cell = row.createCell(colnum);
        }

        style = workbook.createCellStyle();

        style.setFillForegroundColor(
                IndexedColors.RED.getIndex());

        style.setFillPattern(
                FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        // IMPORTANT: Create FileOutputStream before writing
        fo = new FileOutputStream(path);

        workbook.write(fo);

        workbook.close();
        fi.close();
        fo.close();
    }
}