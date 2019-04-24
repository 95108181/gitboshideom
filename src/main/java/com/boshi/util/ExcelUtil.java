package com.boshi.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: chenyong
 * @Date: 2018/5/28 11:13
 **/
public class ExcelUtil {

  private Logger LOG = LoggerFactory.getLogger(getClass());

  private XSSFWorkbook wb;
  private XSSFSheet sheet;
  private XSSFRow row;

  /**
   * 读取Excel表格表头的内容
   *
   * @return String 表头内容的数组
   */
  public String[] readExcelTitle(InputStream is, int sheetSort) {
    try {
      if (null == wb) {
        wb = new XSSFWorkbook(is);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    sheet = wb.getSheetAt(sheetSort);
    row = sheet.getRow(0);
    // 标题总列数
    int colNum = row.getPhysicalNumberOfCells();
    LOG.info("colNum:" + colNum);
    String[] title = new String[colNum];
    for (int i = 0; i < colNum; i++) {
      title[i] = getCellFormatValue(row.getCell(i));
    }
    return title;
  }

  /**
   * 读取Excel数据内容
   *
   * @return Map 包含单元格数据内容的Map对象
   */
  public Map<Integer, String> readExcelContent(InputStream is, int sheetSort) {
    Map<Integer, String> content = new HashMap<Integer, String>();
    String str = "";
    try {
      if (null == wb) {
        wb = new XSSFWorkbook(is);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    //获取第一个sheet的内容，即为Sheet1,具体可以新建一个xlsx查看左下角
    sheet = wb.getSheetAt(sheetSort);
    // 总行数
    int rowNum = sheet.getLastRowNum();
    row = sheet.getRow(0);
    int colNum = row.getPhysicalNumberOfCells();
    // 正文内容应该从第二行开始 index=1
    for (int i = 1; i <= rowNum; i++) {
      row = sheet.getRow(i);
      int j = 0;
      while (j < colNum) {
        str += getCellFormatValue(row.getCell(j)).trim() + "|";
        j++;
      }
      content.put(i, str);
      str = "";
    }
    return content;
  }

  /**
   * 获取单元格数据内容为字符串类型的数据
   *
   * @param cell Excel单元格
   * @return String 单元格数据内容
   */
  private String getStringCellValue(XSSFCell cell) {
    String strCell = "";
    switch (cell.getCellType()) {
      case XSSFCell.CELL_TYPE_STRING:
        strCell = cell.getStringCellValue();
        break;
      case XSSFCell.CELL_TYPE_NUMERIC:
        strCell = String.valueOf(cell.getNumericCellValue());
        break;
      case XSSFCell.CELL_TYPE_BOOLEAN:
        strCell = String.valueOf(cell.getBooleanCellValue());
        break;
      case XSSFCell.CELL_TYPE_BLANK:
        strCell = "";
        break;
      default:
        strCell = "";
        break;
    }
    if (strCell.equals("") || strCell == null) {
      return "";
    }
    if (cell == null) {
      return "";
    }
    return strCell;
  }

  /**
   * 根据XSSFCell类型设置数据
   */
  private String getCellFormatValue(XSSFCell cell) {
    String cellvalue = "";
    if (cell != null) {
      // 判断当前Cell的Type
      switch (cell.getCellType()) {
        // 如果当前Cell的Type为NUMERIC
        case HSSFCell.CELL_TYPE_NUMERIC: {
          cellvalue = new DecimalFormat("#").format(cell.getNumericCellValue());
          break;
        }
        case HSSFCell.CELL_TYPE_FORMULA: {
          // 判断当前的cell是否为Date
          if (HSSFDateUtil.isCellDateFormatted(cell)) {
            // 如果是Date类型，则统一转化为Data格式的字符串
            Date date = cell.getDateCellValue();
            cellvalue = DateUtils.format(date);
          }
          // 如果是纯数字,取得当前Cell的数值
          else {
            cellvalue = String.valueOf(cell.getNumericCellValue());
          }
          break;
        }
        // 如果当前Cell的Type为STRIN
        case HSSFCell.CELL_TYPE_STRING:
          // 取得当前的Cell字符串
          cellvalue = cell.getRichStringCellValue().getString();
          break;
        // 默认的Cell值
        default:
          cellvalue = " ";
      }
    } else {
      cellvalue = "";
    }
    return cellvalue;
  }
}
