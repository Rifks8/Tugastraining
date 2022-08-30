package com.example.demo.controller;

import com.example.demo.dto.TugasDto;
import com.example.demo.dto.http.HttpPagedModel;
import com.example.demo.dto.http.HttpRespModel;
import com.example.demo.service.TugasService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tugas")
public class TugasController {

    private final TugasService tugasService;

    public TugasController(@Qualifier("tugasPlsqlService") TugasService tugasService) {
        this.tugasService = tugasService;
    }

    @GetMapping
    public HttpPagedModel<TugasDto> listData(
            @RequestParam(name = "filter", required = false) String filter,
            @PageableDefault(direction = Sort.Direction.DESC, sort="id") Pageable pageable){
        HttpPagedModel<TugasDto> list = tugasService.getData(filter, pageable);
        return list;
    }

    @PostMapping
    public HttpRespModel<TugasDto> save(@RequestBody @Valid TugasDto dto){
        if(dto.getId() != null) {
            return tugasService.update(dto);
        } else {
            return tugasService.save(dto);
        }
    }

    @PostMapping("/delete/{id}")
    public HttpRespModel<TugasDto> delete(@PathVariable Long id){
        return tugasService.delete(id);
    }

    @PutMapping
    public HttpRespModel<TugasDto> update(@RequestBody @Valid TugasDto dto){
        return tugasService.update(dto);
    }

    @DeleteMapping("/{id}")
    public HttpRespModel<TugasDto> deleteMethod(@PathVariable Long id){
        return tugasService.delete(id);
    }

    @PostMapping("/form")
    public HttpRespModel<TugasDto> saveFormData(@Valid TugasDto dto){
        if(dto.getId() != null) {
            return tugasService.update(dto);
        } else {
            return tugasService.save(dto);
        }
    }

}
