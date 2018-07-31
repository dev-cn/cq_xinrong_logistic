package cq.anbu.common.utils.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelStyleType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.params.ExcelForEachParams;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import cn.afterturn.easypoi.excel.export.template.ExcelExportOfTemplateUtil;
import com.google.common.collect.Lists;
import cq.anbu.common.utils.DateUtils;
import cq.anbu.common.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExcelUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOUtils.class);

    /**
     * 获取自定义excel名
     *
     * @param fileName
     * @return
     */
    public static String getExcelName(String fileName) {
        String excelName;
        try {
            excelName = "[" + URLEncoder.encode(fileName, "UTF-8") + DateUtils.format(new Date(), DateUtils.DATE_PATTERN_YYYYMMDD) + "]";
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("输出文件流Excel异常！", e);
            throw new RuntimeException("获取自定义excel名异常！");
        }
        return excelName;
    }

    /**
     * 模板导出:单个sheet
     *
     * @param targetExcelPath
     * @param map
     * @return
     */
    public static Workbook getWorkbookSingleSheet(String targetExcelPath, Map<String, Object> map) {
        // 获取导出excel指定模版
        TemplateExportParams params = new TemplateExportParams(targetExcelPath);
        // 导出excel
        return ExcelExportUtil.exportExcel(params, map);
    }

    /**
     * 模板导出：多sheet
     *
     * @param targetExcelPath
     * @param sheetMap
     * @return
     */
    public static Workbook getWorkbookManySheet(String targetExcelPath, Map<Integer, Map<String, Object>> sheetMap) {
        // 获取导出excel指定模版
        TemplateExportParams params = new TemplateExportParams(targetExcelPath, true);
        params.setHeadingRows(2);
        params.setStyle(ExcelStyleType.BORDER.getClazz());
        // 导出excel
        ExcelExportOfTemplateUtil excelExportOfTemplateUtil = new ExcelExportOfTemplateUtil();
        excelExportOfTemplateUtil.setExcelExportStyler(new IExcelExportStyler() {
            @Override
            public CellStyle getHeaderStyle(short headerColor) {
                return null;
            }

            @Override
            public CellStyle getTitleStyle(short color) {
                return null;
            }

            @Override
            public CellStyle getStyles(boolean parity, ExcelExportEntity entity) {
                return null;
            }

            @Override
            public CellStyle getStyles(Cell cell, int dataRow, ExcelExportEntity entity, Object obj, Object data) {
                return null;
            }

            @Override
            public CellStyle getTemplateStyles(boolean isSingle, ExcelForEachParams excelForEachParams) {
                return null;
            }
        });
        return excelExportOfTemplateUtil.createExcleByTemplate(params, sheetMap);
    }

    public static void writeSingleExcel(HttpServletResponse response, String targetExcelPath, String excelName, Map<String, Object> map) {
        Workbook workbook = ExcelUtils.getWorkbookSingleSheet(targetExcelPath, map);
        if (workbook == null) {
            LOGGER.info("获取workbook为空！");
        }
        String fileName = ExcelUtils.getExcelName(excelName);
        IOUtils.writeExcel(response, workbook, fileName);
    }

    public static String writeManyExcel(HttpServletResponse response, String targetExcelPath, String excelName, Map<Integer, Map<String, Object>> sheetMap) {
        Workbook workbook = ExcelUtils.getWorkbookManySheet(targetExcelPath, sheetMap);
        if (workbook == null) {
            return "fail";
        }
        String fileName = ExcelUtils.getExcelName(excelName);
        IOUtils.writeExcel(response, workbook, fileName);
        return "success";
    }

    /**
     * 通过反射映射关系
     *
     * @param clazzList
     * @return
     */
    public static List<Map<String, String>> getJavaBeanAttrAndValue(List clazzList) {
        List<Map<String, String>> resultList = Lists.newArrayList();
        for (Object t : clazzList) {
            Field[] declaredFields = t.getClass().getDeclaredFields();
            Field.setAccessible(declaredFields, true);
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    map.put(declaredFields[i].getName(), declaredFields[i].get(t) + "");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            resultList.add(map);
        }
        return resultList;
    }
}
