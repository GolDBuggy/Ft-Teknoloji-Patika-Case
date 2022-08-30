package com.ftteknoloji.patika.Servis;

import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Model.UrunYorum;
import com.ftteknoloji.patika.Repository.KullanıcıRepo;
import com.ftteknoloji.patika.Repository.UrunYorumRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunYorumServis {

    private final UrunYorumRepo urunYorumRepo;
    private final UrunServis urunServis;
    private final KullanıcıServis kullanıcıServis;


    public List<UrunYorum> getAll(){
        return urunYorumRepo.findAll();
    }

    public void yorumKaydet(UrunYorum urunYorum){
        urunYorumRepo.save(urunYorum);
    }

    public List<UrunYorum> urunYorum(long id){
        List<UrunYorum> yorumList=urunYorumRepo.findUrunYorumByUrun(urunServis.urunGetir(id));
        return yorumList;
    }

    public List<UrunYorum> kullaniciYorum(long id){
        List<UrunYorum> yorumList=urunYorumRepo.findUrunYorumByKullanici(kullanıcıServis.kullanıcıGetir(id));
        return yorumList;
    }


    public List<UrunYorum> ikiTariheGoreUrunYorumu(Date ilkTarih,Date ikinciTarih,long id){
        return urunYorumRepo.tarihAraligiUrun(ilkTarih,ikinciTarih,urunServis.urunGetir(id));
    }

    public List<UrunYorum> ikiTariheGoreKullaniciYorumu(Date ilkTarih,Date ikinciTarih,long id){
        return urunYorumRepo.tarihAraligiKullanici(ilkTarih,ikinciTarih,kullanıcıServis.kullanıcıGetir(id));
    }


}
