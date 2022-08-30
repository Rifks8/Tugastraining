package com.example.demo.mapper;

import com.example.demo.dto.TugasDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TugasMapper implements RowMapper<TugasDto> {



    @Override
    public TugasDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        TugasDto dto = new TugasDto();
        dto.setId(rs.getLong("ID"));
        dto.setUsername(rs.getString("USERNAME"));
        dto.setPassword(rs.getString("PASSWORD"));

        if(rs.getInt("IS_ACTIVE") == 1) {
            dto.setActive(true);
        } else {
            dto.setActive(false);
        }

        return dto;
    }
}
