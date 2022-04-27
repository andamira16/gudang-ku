package com.rafiandamira.Gudangproject.service.implementation;

import com.rafiandamira.Gudangproject.entity.Gudang;
import com.rafiandamira.Gudangproject.repository.GudangRepository;
import com.rafiandamira.Gudangproject.service.framework.GudangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GudangServiceImpl implements GudangService {
    private final GudangRepository gudangRepository;

    @Autowired
    public GudangServiceImpl(GudangRepository gudangRepository) {
        this.gudangRepository = gudangRepository;
    }

    @Override
    public List<Gudang> getAllGudang() {
        return gudangRepository.findAll();
    }

    @Override
    public Optional<Gudang> findById(Long id) {
        return gudangRepository.findById(id);
    }

    @Override
    public Optional<Gudang> findByEmail(String email) {
        return gudangRepository.findByEmail(email);
    }

    @Override
    public Gudang save(Gudang std) {
        return gudangRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {
        gudangRepository.deleteById(id);
    }
}
