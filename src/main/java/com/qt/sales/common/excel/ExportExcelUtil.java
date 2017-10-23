/** 
 * 包名: package com.qt.sales.common.excel; <br/> 
 * 添加时间: 2016年11月18日 下午8:32:15 <br/> 
 */
package com.qt.sales.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.qt.sales.utils.ApplicationUtils;
import com.qt.sales.utils.LogPay;

/** 
 * 类名: ExportExcelUtil <br/> 
 * 作用：TODO(导出Excel工具类)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年11月18日 下午8:32:15 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public class ExportExcelUtil {

    /**
     * 
     * 【方法名】    : (导出Excel). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月18日 下午8:35:25 .<br/>
     * 【参数】： .<br/>
     * @param fileNameDes 文件名
     * @param titleList 表头
     * @param valueList 数据
     * @param response response
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public static String exportExcel(String fileNameDes, List<String> titleList, List<List<String>> valueList, HttpServletResponse response) {
        String fileName = fileNameDes;
        String destSrcName = "";
        /* 获取context等对象 */
        HttpServletRequest request = ApplicationUtils.getRequest();
        /* 创建文件名，及路径 */
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        fileName = fileName + "_" + System.nanoTime() + ".xls";
        String filePath = rootPath + fileName;
        /* 在工程中创建文件 */
        WritableWorkbook book = null;
        File file = new File(filePath);
        try {
            // 创建文件
            book = Workbook.createWorkbook(file);
            // 创建1个工作表
            WritableSheet sheet = book.createSheet("Sheet_1", 0);
            // 创建第一行，表头
            for (int i = 0; i < titleList.size(); i++) {
                String title = titleList.get(i);
                // 第0列，第i行插入字符
                Label label = new Label(i, 0, title);
                // 添加到工作表中
                sheet.addCell(label);
                sheet.setColumnView(i, 18); // 设置单元格的宽度
            }
            // 创建表格内容
            for (int i = 0; i < valueList.size(); i++) {
                List<String> values = valueList.get(i);
                for (int j = 0; j < values.size(); j++) {
                    String value = values.get(j);
                    try {
                        // 第j列，第i+1行插入字符
                        Label label = new Label(j, i + 1, value);
                        // 添加到工作表中
                        sheet.addCell(label);
                    } catch (Exception e) {
                        LogPay.error(e.getMessage(), e);
                    }
                }
            }
            // 写出工作表
            book.write();
            // 关闭工作薄对象
            book.close();
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        /* 将文件写出到浏览器 */
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            response.reset();
            response.setContentType("application/xls");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName); //download
            ServletOutputStream servletOutputStream = response.getOutputStream();
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = fileInputStream.read(b)) > 0) {
                servletOutputStream.write(b, 0, i);
            }
            servletOutputStream.flush();
            servletOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        if (file.isFile()) {
            file.delete();
        }
        return destSrcName;
    }
}

