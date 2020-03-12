package com.zhoushengwen.fileDownloadDemo.service;


import com.zhoushengwen.fileDownloadDemo.utils.FileDownloadUtil;
import com.zhoushengwen.fileDownloadDemo.utils.resultUtil.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class DownloadService {
    @Autowired
    private FileDownloadUtil fileDownloadUtil;


    public ReturnResult download(HttpServletResponse response, String fileName) {
        return  fileDownloadUtil.downloadFileById(response,fileName);
    }

}
