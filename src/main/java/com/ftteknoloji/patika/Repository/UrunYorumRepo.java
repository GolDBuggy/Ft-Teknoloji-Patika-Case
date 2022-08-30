package com.ftteknoloji.patika.Repository;

import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Model.Urun;
import com.ftteknoloji.patika.Model.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UrunYorumRepo extends JpaRepository<UrunYorum,Long> {

    List<UrunYorum> findUrunYorumByUrun(Urun urun);

    List<UrunYorum> findUrunYorumByKullanici(Kullanıcı kullanıcı);

    @Query("select u from UrunYorum u where (u.yorumTarihi between :param1 and :param2) and u.kullanici=:param3")
    List<UrunYorum> tarihAraligiKullanici(@Param("param1")Date ilkTarih,@Param("param2") Date ikinciTarih,@Param("param3") Kullanıcı kullanıcı);

    @Query("select u from UrunYorum u where (u.yorumTarihi between :param1 and :param2) and u.urun=:param3")
    List<UrunYorum> tarihAraligiUrun(@Param("param1")Date ilkTarih,@Param("param2") Date ikinciTarih,@Param("param3") Urun urun);


}
