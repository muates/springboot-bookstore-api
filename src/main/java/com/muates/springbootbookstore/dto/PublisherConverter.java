package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.dto.request.PublisherRequest;
import com.muates.springbootbookstore.dto.response.PublisherResponse;

import java.util.List;
import java.util.stream.Collectors;

public class PublisherConverter {

    public static Publisher convertToPublisher(PublisherRequest publisherRequest) {
        return Publisher.builder()
                .id(publisherRequest.getId())
                .name(publisherRequest.getName())
                .build();
    }

    public static PublisherResponse convertToPublisherResponse(Publisher publisher) {
        return PublisherResponse.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .build();
    }

    public static List<PublisherResponse> convertAllPublishersToPublisherResponses(List<Publisher> publisherList) {
        return publisherList.stream().map(PublisherConverter::convertToPublisherResponse).collect(Collectors.toList());
    }

}
