package com.tugas.CRUD_048.controller;

import com.tugas.CRUD_048.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;
}
