package com.ftteknoloji.patika.Servis;

import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Model.Urun;
import com.ftteknoloji.patika.Repository.KullanıcıRepo;
import com.ftteknoloji.patika.Repository.UrunRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunServis {

    private final UrunRepo urunRepo;

    public List<Urun> getAll(){
        return urunRepo.findAll();
    }

    public void urunKaydet(Urun urun){
        urunRepo.save(urun);
    }

    public Urun urunGetir(long id){
        return urunRepo.findById(id).get();
    }

    public List<Urun> tarihiGecmemis(){
        return urunRepo.skTarihiGecmemis();
    }

    public List<Urun> tarihiGecmis(){
        return urunRepo.skTarihiGecmis();
    }
}
