package com.zhoushengwen.fileDownloadDemo.controller;

import com.zhoushengwen.fileDownloadDemo.service.DownloadService;
import com.zhoushengwen.fileDownloadDemo.utils.resultUtil.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DownloadController {
    @Autowired
    DownloadService downloadService;


    @RequestMapping("/download")
    public String download(HttpServletResponse response, String fileName) {
        ReturnResult result = downloadService.download(response, fileName);
        return result.getMsg();
    }


}
