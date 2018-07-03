package cq.anbu.common.utils.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.google.common.collect.Lists;
import cq.anbu.common.utils.DateUtils;
import cq.anbu.common.utils.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

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
     * 模板导出：多sheet
     *
     * @param targetExcelPath
     * @param sheetMap
     * @return
     */
    public static Workbook getWorkbookManySheet(String targetExcelPath, Map<Integer, Map<String, Object>> sheetMap) {
        // 获取导出excel指定模版
        TemplateExportParams params = new TemplateExportParams(targetExcelPath, true);
        // 导出excel
        return ExcelExportUtil.exportExcel(sheetMap, params);
    }


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
