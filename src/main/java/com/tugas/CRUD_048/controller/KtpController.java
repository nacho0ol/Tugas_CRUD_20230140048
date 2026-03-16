package com.tugas.CRUD_048.controller;

import com.tugas.CRUD_048.model.Ktp;
import com.tugas.CRUD_048.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @GetMapping
    public ResponseEntity<List<Ktp>> getAllKtp() {
        List<Ktp> listKtp = ktpService.getAllKtp();
        return new ResponseEntity<>(listKtp, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ktp> getKtpById(@PathVariable Integer id) {
        Ktp ktp = ktpService.getKtpById(id);
        return new ResponseEntity<>(ktp, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ktp> updateKtp(@PathVariable Integer id, @RequestBody Ktp ktpDetails) {
        Ktp updatedKtp = ktpService.updateKtp(id, ktpDetails);
        return new ResponseEntity<>(updatedKtp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return new ResponseEntity<>("Data KTP berhasil dihapus!", HttpStatus.OK);
    }
}
