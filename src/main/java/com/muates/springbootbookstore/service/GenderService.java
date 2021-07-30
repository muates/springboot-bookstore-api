package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.repository.GenderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class GenderService {

    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    public Gender getGenderById(Long id) {
        return genderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Gender does not found!"));
    }

    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }

    public void updateGenderById(Long id, Gender gender) {
        Gender existGender = getGenderById(id);

        if (existGender == null) {
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        genderRepository.save(gender);
    }

    public void deleteGenderById(Long id) {
        Gender gender = getGenderById(id);

        if (gender != null) {
            genderRepository.deleteById(id);
        }
    }
}
