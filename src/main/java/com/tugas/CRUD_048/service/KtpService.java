package com.tugas.CRUD_048.service;

import com.tugas.CRUD_048.model.Ktp;
import com.tugas.CRUD_048.repository.KtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    public List<Ktp> getAllKtp() {
        return ktpRepository.findAll();
    }

    public Ktp getKtpById(Integer id) {
        return ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data KTP dengan ID " + id + " tidak ditemukan!"));
    }

    public Ktp createKtp(Ktp ktp) {
        if (ktpRepository.existsByNomorKtp(ktp.getNomorKtp())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal! Nomor KTP sudah terdaftar.");
        }
        return ktpRepository.save(ktp);
    }

    public Ktp updateKtp(Integer id, Ktp ktpDetails) {
        Ktp existingKtp = getKtpById(id);

        existingKtp.setNomorKtp(ktpDetails.getNomorKtp());
        existingKtp.setNamaLengkap(ktpDetails.getNamaLengkap());
        existingKtp.setAlamat(ktpDetails.getAlamat());
        existingKtp.setTanggalLahir(ktpDetails.getTanggalLahir());
        existingKtp.setJenisKelamin(ktpDetails.getJenisKelamin());

        return ktpRepository.save(existingKtp);
    }

    public void deleteKtp(Integer id) {
        Ktp existingKtp = getKtpById(id);
        ktpRepository.delete(existingKtp);
    }
}
