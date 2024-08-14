package com.lgs.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService
{
    String upload(MultipartFile file);
}
