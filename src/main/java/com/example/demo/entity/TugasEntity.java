package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TUGAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TugasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TUGAS")
    @SequenceGenerator(sequenceName = "SEQ_TUGAS", allocationSize = 1, name = "SEQ_TUGAS")

    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active", columnDefinition = "Number(1)")
    private Boolean active;

}
