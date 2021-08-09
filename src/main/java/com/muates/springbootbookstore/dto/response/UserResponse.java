package com.muates.springbootbookstore.dto.response;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.domain.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private Gender gender;
    private Integer age;
    private GenderEnum genderEnum;

}
