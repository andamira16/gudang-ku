package com.rafiandamira.Gudangproject.repository;

import com.rafiandamira.Gudangproject.entity.Gudang;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GudangRepository extends JpaRepository<Gudang, Long> {
    Optional<Gudang> findByEmail(String email);
}
