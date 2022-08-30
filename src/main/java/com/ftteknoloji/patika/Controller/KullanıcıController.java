package com.ftteknoloji.patika.Controller;

import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Servis.KullanıcıServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullanıcıController {

    private final KullanıcıServis kullanıcıServis;

    @GetMapping("/getir")
    public ResponseEntity<List<Kullanıcı>> getAll(){
        return ResponseEntity.ok(kullanıcıServis.getAll());
    }

    @PostMapping("/kayit")
    public Kullanıcı kayıt(@RequestBody Kullanıcı kullanıcı){
        kullanıcıServis.kullaniciKaydet(kullanıcı);

        return kullanıcı;
    }

}
