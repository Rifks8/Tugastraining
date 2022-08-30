package com.example.demo.service;

import com.example.demo.dto.TugasDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class TugasServiceTest {

    @Autowired
    @Qualifier("tugasJpaService")
//    @Qualifier("tugasPlsqlService")
    TugasService service;

    @Test
    public void getData() {
        service.getData(null, PageRequest.of(0, 10));
    }

    @Test
    public void saveData() {
        TugasDto dto = new TugasDto();
		dto.setUsername("Tes123");
        dto.setPassword("1111");

        try {
            System.out.println("Sebelum panggil method save");
            service.save(dto);
            System.out.println("Setelah panggil method save");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Selesai menjalankan method");
        }
    }

}
