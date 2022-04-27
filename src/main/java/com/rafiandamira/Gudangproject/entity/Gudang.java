package com.rafiandamira.Gudangproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gudang")
public class Gudang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Barang name is required")
    @Column(nullable = false, name = "barangName")
    private String barangName;

    @NotEmpty(message = "Pemilik name is required")
    @Column(nullable = false, name = "pemilikName")
    private String pemilikName;

    @NotEmpty(message = "jumlah is required")
    @Column(nullable = false, name = "jumlah")
    private String jumlah;

    @NotEmpty(message = "email is required")
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotNull(message = "Please enter your Barang date!")
    @Past(message = "Barang date should be less than current date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate barangDate;
}

