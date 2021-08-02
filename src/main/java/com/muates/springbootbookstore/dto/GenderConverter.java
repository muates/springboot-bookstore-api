package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.dto.request.GenderRequest;
import com.muates.springbootbookstore.dto.response.GenderResponse;

import java.util.List;
import java.util.stream.Collectors;

public class GenderConverter {

    public static Gender convertToGender(GenderRequest genderRequest) {
        return Gender.builder()
                .id(genderRequest.getId())
                .gender(genderRequest.getGender())
                .build();
    }

    public static GenderResponse convertToGenderResponse(Gender gender) {
        return GenderResponse.builder()
                .id(gender.getId())
                .gender(gender.getGender())
                .build();
    }

    public static List<GenderResponse> convertAllGendersToUserResponses(List<Gender> genderList) {
        return genderList.stream().map(GenderConverter::convertToGenderResponse).collect(Collectors.toList());
    }
}
