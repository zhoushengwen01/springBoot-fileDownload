package com.zhoushengwen.fileDownloadDemo.utils;

import com.zhoushengwen.fileDownloadDemo.utils.resultUtil.ResultEnum;
import com.zhoushengwen.fileDownloadDemo.utils.resultUtil.ReturnResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class FileDownloadUtil {
    @Value("${folderPath}")
    private String folderPath;
    @Value("${suffix}")
    private String suffix;

    public ReturnResult downloadFileById(HttpServletResponse response, String fileId) {
        if (!StringUtils.isEmpty(fileId.trim())) {
            String path = folderPath + fileId.trim() + suffix;
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
            if (resourceAsStream == null) {
                return ReturnResult.error(ResultEnum.RESOURCES_IS_NULL);
            }

            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileId + suffix);

            byte[] buffer = new byte[8*1024];
            BufferedInputStream bis = null;
            try {
                bis = new BufferedInputStream(resourceAsStream);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
                return ReturnResult.error();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return ReturnResult.success();
        } else {
            return ReturnResult.error(ResultEnum.FIlE_NAME_IS_EMPTY);
        }

    }


}
