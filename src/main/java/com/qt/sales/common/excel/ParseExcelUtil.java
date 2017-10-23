/** 
 * 包名: package com.qt.sales.common.excel; <br/> 
 * 添加时间: 2016年11月9日 下午2:31:37 <br/> 
 */
package com.qt.sales.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.qt.sales.utils.LogPay;

/**
 * 类名: ParseExcelUtil <br/>
 * 作用：TODO(读取Excel公用类)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年11月9日 下午2:31:37 <br/>
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public class ParseExcelUtil {


    /**
     * Workbook对象
     */
    public static Workbook wb     = null;

    /**
     * 单元Sheet
     */
    public static Sheet    sheet  = null;

    /**
     * 单元格
     */
    public static Cell     cell   = null;

    /**
     * 行
     */
    public static Row      row    = null;

    /**
     * 【方法名】    : (解析Excel文件). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月9日 下午4:40:41 .<br/>
     * 【参数】： .<br/>
     * @param multipartFile MultipartFile文件类型
     * @param excelFilePath 路径
     * @return List<SheetBean>
     * @throws IOException .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public static List<SheetBean> parseMultipleExcel(MultipartFile multipartFile, String excelFilePath) throws IOException {
        List<SheetBean> sheetBeans = new ArrayList<SheetBean>();
        InputStream stream = null;
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(excelFilePath));
            stream = new FileInputStream(excelFilePath);
            if (excelFilePath.endsWith(".xls")) {
                wb = (Workbook) new HSSFWorkbook(stream);
            } else if (excelFilePath.endsWith(".xlsx")) {
                wb = (Workbook) new XSSFWorkbook(stream);
            }
            if (wb != null) {
                int sheetNum = wb.getNumberOfSheets();
                for (int m = 0; m < sheetNum; m++) {
                    if (null != wb.getSheetAt(m)) {
                        SheetBean sheetBean = new SheetBean();
                        sheet = wb.getSheetAt(m);
                        if (sheet != null) {
                            LogPay.info("sheetName: " + sheet.getSheetName());
                            // 行数(从0开始,相当于最后一行的索引),列数
                            if (sheet.getLastRowNum() != 0 && sheet.getRow(0).getPhysicalNumberOfCells() != 0) {
                                int countRow = sheet.getLastRowNum();
                                int countCell = sheet.getRow(0).getPhysicalNumberOfCells();
                                String[][] strArray = new String[countRow][countCell];
                                sheetBean.setVarNameList(ParseExcelUtil.getHeaderRow(sheet.getRow(1)));
                                for (int i = 0; i < countRow; i++) {
                                    for (int j = 0; j < countCell; j++) {
                                        if (sheet.getRow(i + 1) != null) {
                                            row = sheet.getRow(i + 1);
                                        }
                                        cell = row.getCell(j);
                                        String objConet = ParseExcelUtil.convertCellValue(cell);
                                        strArray[i][j] = objConet;
                                    }
                                }
                                sheetBean.setSheetData(strArray);
                                sheetBeans.add(sheetBean);
                                cell = null;
                                row = null;
                                sheet = null;
                            }
                        }
                    }
                }
            }
            wb = null;
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return sheetBeans;
    }


    /**
     * 
     * 【方法名】    : (获取定义名称行). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月9日 下午5:08:18 .<br/>
     * 【参数】： .<br/>
     * @param row Row行记录
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private static List<String> getHeaderRow(Row row) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            list.add(convertCellValue(row.getCell(i)));
        }
        return list;
    }

    /**
     * 
     * 【方法名】    : (转换单元格数据的格式). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月9日 下午5:08:46 .<br/>
     * 【参数】： .<br/>
     * @param cell Cell对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private static String convertCellValue(Cell cell) {
        String cellVal = "";
        if (cell == null){
            return cellVal;
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                cellVal = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellVal = com.qt.sales.utils.DateUtil.format(cell.getDateCellValue(), com.qt.sales.utils.DateUtil.YYYYMMDDHHMMSS);
                } else {
                    cellVal = String.valueOf(new Long((long) cell.getNumericCellValue()));
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellVal = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellVal = cell.getCellFormula();
                break;
            default:
                break;
        }
        return cellVal;
    }

}
