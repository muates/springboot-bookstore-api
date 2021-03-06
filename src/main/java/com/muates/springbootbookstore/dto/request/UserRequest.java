package com.muates.springbootbookstore.dto.request;

import com.muates.springbootbookstore.domain.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 15)
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 18)
    @NaturalId
    @Column(unique = true)
    private String userName;

    @NotBlank
    @Email
    @NaturalId
    @Column(unique = true)
    private String mail;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(unique = true)
    private String tcNo;

    private Date birthday;
    private GenderEnum genderEnum;
}
