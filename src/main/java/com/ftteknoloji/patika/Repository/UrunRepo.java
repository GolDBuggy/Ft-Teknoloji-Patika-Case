package com.ftteknoloji.patika.Repository;

import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Model.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UrunRepo extends JpaRepository<Urun,Long> {

    @Query("select u from Urun u where u.skTarihi>current_date or u.skTarihi is null ")
    List<Urun> skTarihiGecmemis();

    @Query("select u from Urun u where u.skTarihi<current_date ")
    List<Urun> skTarihiGecmis();
}
