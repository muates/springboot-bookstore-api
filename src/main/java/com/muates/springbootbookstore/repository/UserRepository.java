package com.muates.springbootbookstore.repository;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByGender(Gender gender);

}
