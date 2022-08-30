package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Getter @Setter
@ToString
@NoArgsConstructor
public class TugasDto implements Comparable<TugasDto>{

    private Long id;
    @NotBlank(message = "Nama username harus diisi")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,50}$", message = "Invalid username")

    private String username;

    private String password;

    private Boolean active;

    @Builder
    public TugasDto(Long id, String username, String password, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TugasDto other = (TugasDto) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int compareTo(TugasDto o) {
        return id.compareTo(o.getId());
    }
}
