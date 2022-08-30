package com.example.demo.comparator;

import com.example.demo.dto.TugasDto;

import java.util.Comparator;

public class TugasSortDesc implements Comparator<TugasDto> {

    @Override
    public int compare(TugasDto o1, TugasDto o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
