package com.ftteknoloji.patika.Repository;

import com.ftteknoloji.patika.Model.Kullanıcı;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullanıcıRepo extends JpaRepository<Kullanıcı,Long> {
}
