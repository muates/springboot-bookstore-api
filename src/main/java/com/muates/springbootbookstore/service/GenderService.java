package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.exception.ResourceNotFoundException;
import com.muates.springbootbookstore.repository.GenderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return genderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gender does not found!"));
    }

    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }

    public void updateGenderById(Long id, Gender gender) {
        getGenderById(id);
        genderRepository.save(gender);
    }

    public void deleteGenderById(Long id) {
        Gender gender = getGenderById(id);

        if (gender != null) {
            genderRepository.deleteById(id);
        }
    }
}
