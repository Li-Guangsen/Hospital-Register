package com.lgs.backend.service.impl;

import com.lgs.backend.service.UploadFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Value("${upload.dir}")
    private String UPLOAD_DIR ;
//    @Value("${upload.server.path}")
//    private String UPLOAD_SERVER_PATH;
    /*
    return访问路径
     */
    @Override
    public String upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
        String newFileName = System.currentTimeMillis() + suffix;
        File dir = new File(UPLOAD_DIR + "images/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        try {
            File newFile = new File(dir, newFileName);
            file.transferTo(newFile);
            return "/pic/images/" + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
