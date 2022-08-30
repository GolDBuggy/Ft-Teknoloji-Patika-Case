# Ft-Teknoloji-Patika-Case
Ft Teknoloji Patika Case

İbrahim Hakkı Kılıç Ft Teknoloji Patika.dev Case 30.08.2022

Bir ürüne ait yorumları listeleyen bir metot yazınız.
```
localhost:8080/yorum/urun/{id}

localhost:8080/yorum/urun/2 =>
[
    {
        "id": 6,
        "yorum": "Şarjı çabuk bitiyor",
        "yorumTarihi": "11-09-2022",
        "urun": {
            "id": 2,
            "urunAdı": "Tablet",
            "fiyat": 8756.36,
            "skTarihi": null
        },
        "kullanici": {
            "id": 1,
            "ad": "ibrahim",
            "soyad": "kılıç",
            "email": "ibo@gmail.com",
            "telefon": "05558889977"
        }
    }
]

```

Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
```
localhost:8080/yorum/urun?ilktarih=2022/08/08&ikincitarih=2022/09/31&urunId=1  =>

[
    {
        "id": 3,
        "yorum": "Urunun ekran kartı iyi ama ramleri düşük.",
        "yorumTarihi": "11-08-2022",
        "urun": {
            "id": 1,
            "urunAdı": "Laptop",
            "fiyat": 15999.99,
            "skTarihi": "29-09-2022"
        },
        "kullanici": {
            "id": 1,
            "ad": "ibrahim",
            "soyad": "kılıç",
            "email": "ibo@gmail.com",
            "telefon": "05558889977"
        }
    },
    {
        "id": 5,
        "yorum": "Laptop istedigim ozellikleri karsıladı",
        "yorumTarihi": "30-08-2022",
        "urun": {
            "id": 1,
            "urunAdı": "Laptop",
            "fiyat": 15999.99,
            "skTarihi": "29-09-2022"
        },
        "kullanici": {
            "id": 2,
            "ad": "hakkı",
            "soyad": "kılıç",
            "email": "hakkı@gmail.com",
            "telefon": "05337775522"
        }
    }
]

```

Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
```
localhost:8080/yorum/kullanici/{id}

localhost:8080/yorum/kullanici/2 =>
[
    {
        "id": 5,
        "yorum": "Laptop istedigim ozellikleri karsıladı",
        "yorumTarihi": "30-08-2022",
        "urun": {
            "id": 1,
            "urunAdı": "Laptop",
            "fiyat": 15999.99,
            "skTarihi": "29-09-2022"
        },
        "kullanici": {
            "id": 2,
            "ad": "hakkı",
            "soyad": "kılıç",
            "email": "hakkı@gmail.com",
            "telefon": "05337775522"
        }
    }
]
```

Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız. 
```
localhost:8080/yorum/kullanici?ilktarih=2022/08/08&ikincitarih=2022/09/31&kullaniciId=1 =>
[
    {
        "id": 3,
        "yorum": "Urunun ekran kartı iyi ama ramleri düşük.",
        "yorumTarihi": "11-08-2022",
        "urun": {
            "id": 1,
            "urunAdı": "Laptop",
            "fiyat": 15999.99,
            "skTarihi": "29-09-2022"
        },
        "kullanici": {
            "id": 1,
            "ad": "ibrahim",
            "soyad": "kılıç",
            "email": "ibo@gmail.com",
            "telefon": "05558889977"
        }
    },
    {
        "id": 6,
        "yorum": "Şarjı çabuk bitiyor",
        "yorumTarihi": "11-09-2022",
        "urun": {
            "id": 2,
            "urunAdı": "Tablet",
            "fiyat": 8756.36,
            "skTarihi": null
        },
        "kullanici": {
            "id": 1,
            "ad": "ibrahim",
            "soyad": "kılıç",
            "email": "ibo@gmail.com",
            "telefon": "05558889977"
        }
    }
]
```

Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
```
localhost:8080/urun/tarihigecmis =>
[
    {
        "id": 4,
        "urunAdı": "Süt",
        "fiyat": 26.99,
        "skTarihi": "16-08-2022"
    }
]
```

Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
```
localhost:8080/urun/tarihigecmemis =>
[
    {
        "id": 2,
        "urunAdı": "Tablet",
        "fiyat": 8756.36,
        "skTarihi": null
    },
    {
        "id": 1,
        "urunAdı": "Laptop",
        "fiyat": 15999.99,
        "skTarihi": "29-09-2022"
    }
]

```

PostgreSQL Tablolar
```
create table kullanıcı(
  kullanici_id serial primary key,
  ad varchar(50) not null,
  soyad varchar(50) not null,
  email varchar(50) not null,  
  telefon varchar(15) not null  
);

create table urun(
  urun_id serial primary key,
  urun_adı text not null,
  fiyat numeric not null,
  sk_tarihi date 
);


create table urun_yorum(
  yorum_id serial primary key,
  yorum varchar(500) not null,
  yorum_tarihi date not null,
  urun_id serial not null,
  kullanici_id serial not null,
    
  CONSTRAINT ft_urn foreign key (urun_id) references urun(urun_id),
  CONSTRAINT ft_kuln foreign key (kullanici_id) references kullanıcı(kullanici_id)

);
```






