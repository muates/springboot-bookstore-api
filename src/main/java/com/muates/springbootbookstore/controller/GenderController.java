package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.dto.GenderConverter;
import com.muates.springbootbookstore.dto.request.GenderRequest;
import com.muates.springbootbookstore.dto.response.GenderResponse;
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
    public ResponseEntity<List<GenderResponse>> getAllGenders() {
        List<Gender> genderList = genderService.getAllGenders();
        return ResponseEntity.ok(GenderConverter.convertAllGendersToUserResponses(genderList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderResponse> getGenderById(@PathVariable Long id) {
        GenderResponse genderResponse = GenderConverter.convertToGenderResponse(genderService.getGenderById(id));
        return ResponseEntity.ok(genderResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<GenderResponse> saveGender(@Valid @RequestBody GenderRequest genderRequest) {
        Gender savedGender = genderService.saveGender(GenderConverter.convertToGender(genderRequest));
        return ResponseEntity.ok(GenderConverter.convertToGenderResponse(savedGender));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGenderById(@PathVariable Long id, @Valid @RequestBody GenderRequest genderRequest) {
        Gender gender = GenderConverter.convertToGender(genderRequest);
        genderService.updateGenderById(id, gender);
        return ResponseEntity.ok("Gender is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenderById(@PathVariable Long id) {
        genderService.deleteGenderById(id);
        return ResponseEntity.ok("Gender is deleted");
    }

}
