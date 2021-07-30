package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.dto.request.GenderRequest;
import com.muates.springbootbookstore.service.GenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Gender>> getAllGenders() {
        return ResponseEntity.ok(genderService.getAllGenders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable Long id) {
        return ResponseEntity.ok(genderService.getGenderById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Gender> saveGender(@Valid @RequestBody GenderRequest genderRequest) {
        Gender gender = convertToGender(genderRequest);
        return ResponseEntity.ok(genderService.saveGender(gender));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGenderById(@PathVariable Long id, @Valid @RequestBody Gender gender) {
        genderService.updateGenderById(id, gender);
        return ResponseEntity.ok("Gender is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenderById(@PathVariable Long id) {
        genderService.deleteGenderById(id);
        return ResponseEntity.ok("Gender is deleted");
    }

    private Gender convertToGender(GenderRequest genderRequest) {
        return Gender.builder()
                .gender(genderRequest.getGender())
                .build();
    }
}
