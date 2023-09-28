package com.difi.contract.controller;

import com.difi.contract.dto.HanMucThauChiRequest;
import com.difi.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/bieu-mau")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/han-muc-thau-chi")
    public ResponseEntity<byte[]> getHtml(@RequestBody HanMucThauChiRequest request) throws Exception {
        return contractService.createHanMucThauChi(request);

    }
}
