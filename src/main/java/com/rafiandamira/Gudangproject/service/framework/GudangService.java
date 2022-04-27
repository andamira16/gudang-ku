package com.rafiandamira.Gudangproject.service.framework;

import com.rafiandamira.Gudangproject.entity.Gudang;

import java.util.List;
import java.util.Optional;

public interface GudangService {
    List<Gudang> getAllGudang();

    Optional<Gudang> findById(Long id);

    Optional<Gudang> findByEmail(String email);

    Gudang save(Gudang std);

    void deleteById(Long id);
}
