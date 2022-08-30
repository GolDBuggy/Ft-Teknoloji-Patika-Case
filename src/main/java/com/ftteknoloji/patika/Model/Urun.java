package com.ftteknoloji.patika.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "urun")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urun_id")
    private long id;

    @Column(name = "urun_adı")
    private String urunAdı;

    @Column(name = "fiyat")
    private BigDecimal fiyat;

    @Column(name = "sk_tarihi")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate skTarihi;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "urun")
    @JsonIgnore
    private List<UrunYorum> urunYorumList;


}
