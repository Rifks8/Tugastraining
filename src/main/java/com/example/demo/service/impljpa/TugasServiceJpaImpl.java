package com.example.demo.service.impljpa;

import com.example.demo.dao.TugasDao;
import com.example.demo.dto.CustomException;
import com.example.demo.dto.TugasDto;
import com.example.demo.dto.http.HttpPagedModel;
import com.example.demo.dto.http.HttpRespModel;
import com.example.demo.entity.TugasEntity;
import com.example.demo.service.TugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TugasServiceJpaImpl implements TugasService {

    @Autowired
    private TugasDao dao;

    @Override
    public HttpRespModel save(TugasDto dto) {
        TugasEntity entity = new TugasEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setActive(Boolean.TRUE);

        dao.save(entity);
        return HttpRespModel.ok(null, "Save user sukses");
    }

    @Override
    public HttpRespModel update(TugasDto dto) {
        Optional<TugasEntity> exist = dao.findById(dto.getId());
        if(!exist.isPresent()) {
            throw new CustomException("Data tidak ditemukan");
        }

        TugasEntity entity = exist.get();
        entity.setUsername(dto.getUsername());

        dao.save(entity);
        return HttpRespModel.ok(null, "Update user sukses");
    }

    @Override
    public HttpRespModel delete(Long id) {
        Optional<TugasEntity> exist = dao.findById(id);
        if(!exist.isPresent()) {
            throw new CustomException("Data tidak ditemukan");
        }

        dao.delete(exist.get());
        return HttpRespModel.ok(null, "Delete jabatan sukses");
    }

    @Override
    public HttpPagedModel<TugasDto> getData(String filter, Pageable pageable) {
        if(StringUtils.hasText(filter)) {
            filter = "%" + filter + "%";
        }

        Page<TugasEntity> listData = dao.findByNama(filter, pageable);
        List<TugasDto> listDto = new ArrayList<TugasDto>();

        System.out.println("Data :");
        listData.stream().forEach(x -> {
            TugasDto dto = new TugasDto(x.getId(), x.getUsername(), x.getPassword(), x.getActive());
            System.out.println(" -> " + dto.toString());
            listDto.add(dto);
        });
        return HttpPagedModel.ok(listDto, listData.getNumberOfElements(), listData.getTotalElements());
    }
}
