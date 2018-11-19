package com.kat.lap_trinh_web.common.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUtil {
//    @Value("${system.file_upload_dir}")
//    private String fileUploadDir;

//    public String uploadFile(byte[] fileData, String fileCode) throws IOException {
//        String filePath = fileUploadDir + File.separator + fileCode + ".lap_trinh_web";
//        try (FileOutputStream fos = new FileOutputStream(filePath)) {
//            fos.write(fileData);
//        }
//        return filePath;
//    }

    public byte[] readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    public void removeFile(String filepath){
        File file = new File(filepath);
        if(file.exists() && file.canWrite()){
            file.delete();
        }
    }

}
