package com.zhouzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/4/30 周二
 * @time 11:09
 * @desc
 */

@RestController
@RequestMapping("/file")
public class FileTestController {
    @RequestMapping("/addFile")
    public String addFile(@RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println("文件名称:" + fileName);
        String basePath = "/data/test";
        File uploadFile = new File(basePath + "/" + fileName);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        file.transferTo(uploadFile);
        return fileName;
    }

}
