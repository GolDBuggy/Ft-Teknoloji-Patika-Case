package com.ftteknoloji.patika.Controller;

import com.ftteknoloji.patika.Model.Urun;
import com.ftteknoloji.patika.Model.UrunYorum;
import com.ftteknoloji.patika.Servis.UrunServis;
import com.ftteknoloji.patika.Servis.UrunYorumServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/yorum")
@RequiredArgsConstructor
public class UrunYorumController {

    private final UrunYorumServis yorumServis;

    @GetMapping("/getir")
    public ResponseEntity<List<UrunYorum>> getAll(){
        return ResponseEntity.ok(yorumServis.getAll());
    }

    @PostMapping("/kayit")
    public UrunYorum kayıt(@RequestBody UrunYorum urunYorum){
        yorumServis.yorumKaydet(urunYorum);

        return urunYorum;
    }


    @GetMapping("/urun/{id}")
    public ResponseEntity<List<UrunYorum>> urunYorumGetir(@PathVariable long id){
        return ResponseEntity.ok(yorumServis.urunYorum(id));
    }

    @GetMapping("/kullanici/{id}")
    public ResponseEntity<List<UrunYorum>> kullaniciYorumGetir(@PathVariable long id){
        return ResponseEntity.ok(yorumServis.kullaniciYorum(id));
    }


    @GetMapping("/kullanici")
    public ResponseEntity<List<UrunYorum>> tariheGoreKullanici(@RequestParam("ilktarih")Date baslangicTarihi,
                                                      @RequestParam("ikincitarih")Date bitisTarihi,
                                                      @RequestParam("kullaniciId") long id){

        return ResponseEntity.ok(yorumServis.ikiTariheGoreKullaniciYorumu(baslangicTarihi,bitisTarihi,id));
    }

    @GetMapping("/urun")
    public ResponseEntity<List<UrunYorum>> tariheGoreUrun(@RequestParam("ilktarih")Date baslangicTarihi,
                                                               @RequestParam("ikincitarih")Date bitisTarihi,
                                                               @RequestParam("urunId") long id){

        return ResponseEntity.ok(yorumServis.ikiTariheGoreUrunYorumu(baslangicTarihi,bitisTarihi,id));
    }

}
