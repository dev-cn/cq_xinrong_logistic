package cq.anbu.common.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class IOUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOUtils.class);

    private static final String EXCEL_SUFFIX_XLSX = ".xlsx";

    /**
     * 输出文件流Excel
     *
     * @param response
     * @param workbook
     * @param fileName
     */
    public static void writeExcel(HttpServletResponse response, Workbook workbook, String fileName) {
        try {
            response.reset(); // 重置响应对象
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + EXCEL_SUFFIX_XLSX);  // 指定下载的文件名--设置响应头
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            LOGGER.error("输出文件流Excel异常！", e);
            throw new RuntimeException("输出文件流Excel异常！");
        }
    }


}
