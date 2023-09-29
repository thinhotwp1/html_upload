package com.difi.contract.service;

import com.difi.contract.dto.HanMucThauChiRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class ContractService {
    /**
     * Lấy thông tin khách hàng từ request gán vào file html
     * Return biểu mẫu chứa thông tin khách hàng
     */
    public ResponseEntity<byte[]> createHanMucThauChi(HanMucThauChiRequest request) throws Exception {
        // Đường dẫn tới file HTML trong thư mục resources
        String filePath = "static/01a-TC.html";

        // Đọc file HTML từ resources
        Resource resource = new ClassPathResource(filePath);
        byte[] fileData = Files.readAllBytes(resource.getFile().toPath());

        // Chuyển dữ liệu HTML thành chuỗi
        String htmlContent = new String(fileData, StandardCharsets.UTF_8);

        htmlContent = htmlContent.replace("<p>Họ và tên: ....................................................................................................................................................................", "<p>Họ và tên: " + request.getNameCustomer() + "<p>");
        // ... Tương tự với các dòng dưới
        // ... Tương tự với các dòng dưới
        // ... Tương tự với các dòng dưới


        // Chuyển lại thành mảng byte
        byte[] updatedFileData = htmlContent.getBytes(StandardCharsets.UTF_8);

        // Trả về file dưới dạng attachment
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .header("Content-Disposition", "attachment; filename=01a-TC.html")
                .body(updatedFileData);
    }
}
