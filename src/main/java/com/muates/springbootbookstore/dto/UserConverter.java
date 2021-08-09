package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.dto.request.UserRequest;
import com.muates.springbootbookstore.dto.response.UserResponse;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static User convertToUser(UserRequest userRequest) {

        return User.builder()
                .id(userRequest.getId())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .userName(userRequest.getUserName())
                .mail(userRequest.getMail())
                .tcNo(userRequest.getTcNo())
                .gender(userRequest.getGender())
                .birthday(userRequest.getBirthday())
                .genderEnum(userRequest.getGenderEnum())
                .build();
    }

    public static UserResponse convertToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .gender(user.getGender())
                .genderEnum(user.getGenderEnum())
                .age(Math.abs(user.getBirthday().getYear() - new Date().getYear()))
                .build();
    }

    public static List<UserResponse> convertAllUsersToUserResponses(List<User> userList) {
        return userList.stream().map(UserConverter::convertToUserResponse).collect(Collectors.toList());
    }

}
