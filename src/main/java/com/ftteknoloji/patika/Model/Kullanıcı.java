package com.ftteknoloji.patika.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kullanıcı")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Kullanıcı {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kullanici_id")
    private long id;

    @Column(name = "ad",length = 50)
    private String ad;

    @Column(name = "soyad",length = 50)
    private String soyad;

    @Column(name = "email",length = 50)
    private String email;

    @Column(name = "telefon",length = 15)
    private String telefon;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "kullanici")
    @JsonIgnore
    private List<UrunYorum> urunYorums;


}
