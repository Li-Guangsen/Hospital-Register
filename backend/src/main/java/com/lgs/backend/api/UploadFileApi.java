package com.lgs.backend.api;

import com.lgs.backend.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/uploads", produces = "application/json;charset=utf-8")
public class UploadFileApi {
    private UploadFileService uploadFileService;
    @Autowired
    public UploadFileApi(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }
    @PostMapping("/photo")
    public Map<String,Object> uploadAvatar(MultipartFile file){
        String url = uploadFileService.upload(file);
        return Map.of("success",true,"url",url);
    }
}
