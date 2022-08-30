package com.example.demo.service;

import com.example.demo.dto.TugasDto;
import com.example.demo.dto.http.HttpPagedModel;
import com.example.demo.dto.http.HttpRespModel;
import org.springframework.data.domain.Pageable;

public interface TugasService {

    public HttpRespModel save(TugasDto dto);
    public HttpRespModel update(TugasDto dto);
    public HttpRespModel delete(Long id);
    public HttpPagedModel<TugasDto> getData(String filter, Pageable pageable);

}
