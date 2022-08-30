package com.ftteknoloji.patika.Controller;

import com.ftteknoloji.patika.ExceptionHandle.EntityException;
import com.ftteknoloji.patika.Model.Kullanıcı;
import com.ftteknoloji.patika.Model.Urun;
import com.ftteknoloji.patika.Servis.KullanıcıServis;
import com.ftteknoloji.patika.Servis.UrunServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urun")
@RequiredArgsConstructor
public class UrunController {

    private final UrunServis urunServis;

    @GetMapping("/getir")
    public ResponseEntity<List<Urun>> getAll(){
        return ResponseEntity.ok(urunServis.getAll());
    }

    @PostMapping("/kayit")
    public Urun kayıt(@RequestBody Urun urun){
        urunServis.urunKaydet(urun);
        return urun;
    }


    @GetMapping("/tarihigecmemis")
    public ResponseEntity<List<Urun>> tarihiGecmemis(){
        return ResponseEntity.ok(urunServis.tarihiGecmemis());
    }

    @GetMapping("/tarihigecmis")
    public ResponseEntity<List<Urun>> tarihiGecmis(){
        return ResponseEntity.ok(urunServis.tarihiGecmis());
    }

}
