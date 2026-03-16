package com.tugas.CRUD_048.repository;

import com.tugas.CRUD_048.model.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Integer> {

    boolean existsByNomorKtp(String nomorKtp);

}
