package com.ftteknoloji.patika.Model;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "urun_yorum")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrunYorum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yorum_id")
    private long id;

    @Column(name = "yorum",length = 500)
    private String yorum;

    @Column(name = "yorum_tarihi")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date yorumTarihi;

    @ManyToOne
    @JoinColumn(name = "urun_id")
    private Urun urun;

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanıcı kullanici;

}
