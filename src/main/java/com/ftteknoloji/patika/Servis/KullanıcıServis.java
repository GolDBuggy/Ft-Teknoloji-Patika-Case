package com.ftteknoloji.patika.Servis;

import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Repository.KullanıcıRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KullanıcıServis {

    private final KullanıcıRepo kullanıcıRepo;

    public List<Kullanıcı> getAll(){
        return kullanıcıRepo.findAll();
    }

    public void kullaniciKaydet(Kullanıcı kullanıcı){
        kullanıcıRepo.save(kullanıcı);
    }


    public Kullanıcı kullanıcıGetir(long id){
        return  kullanıcıRepo.findById(id).get();
    }
}
