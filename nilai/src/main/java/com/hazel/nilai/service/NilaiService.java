/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hazel.nilai.service;

import com.hazel.nilai.entity.Nilai;
import com.hazel.nilai.repository.NilaiRepository;
import com.hazel.nilai.vo.Mahasiswa;
import com.hazel.nilai.vo.Matakuliah;
import com.hazel.nilai.vo.ResponseTemplate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Asus
 */
@Service
public class NilaiService {

    @Autowired
    private NilaiRepository nilaiRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Nilai> getAll() {
        return nilaiRepository.findAll();
    }

    public void insert(Nilai nilai) {
        nilaiRepository.save(nilai);

    }

    public List<ResponseTemplate> getNilaiById(Long id) {
        List<ResponseTemplate> responseList = new ArrayList<>();

        List<Nilai> nilaiList = nilaiRepository.findByIdMahasiswa(id);

        for (Nilai nilai : nilaiList) {
            Mahasiswa mahasiswa
                    = restTemplate.getForObject("http://localhost:9001/api/v1/mahasiswa/"
                            + nilai.getIdmahasiswa(), Mahasiswa.class);

            Matakuliah matakuliah
                    = restTemplate.getForObject("http://localhost:9002/api/v1/matakuliah/"
                            + nilai.getIdmatakuliah(), Matakuliah.class);
            
            ResponseTemplate vo = new ResponseTemplate();
            vo.setNilai(nilai);
            vo.setMahasiswa(mahasiswa);
            vo.setMatakuliah(matakuliah);
            responseList.add(vo);
            
        }
        return responseList;

    }

}
