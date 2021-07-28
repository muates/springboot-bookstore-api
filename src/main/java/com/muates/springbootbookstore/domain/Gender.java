package com.muates.springbootbookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;

}
