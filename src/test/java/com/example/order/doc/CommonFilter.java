package com.example.order.doc;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

public class CommonFilter {

    public List<FieldDescriptor> setPagingFilter(List<FieldDescriptor> fieldDescriptors) {
        fieldDescriptors.addAll(Arrays.asList(
                fieldWithPath("data.pageable").type(JsonFieldType.OBJECT).description("페이징 가능 여부"),
                fieldWithPath("data.pageable.sort").type(JsonFieldType.OBJECT).description("정렬"),
                fieldWithPath("data.pageable.sort.empty").type(JsonFieldType.BOOLEAN).description("설명 1"),
                fieldWithPath("data.pageable.sort.sorted").type(JsonFieldType.BOOLEAN).description("설명 2"),
                fieldWithPath("data.pageable.sort.unsorted").type(JsonFieldType.BOOLEAN).description("설명 3"),
                fieldWithPath("data.pageable.offset").type(JsonFieldType.NUMBER).description("설명 4"),
                fieldWithPath("data.pageable.pageNumber").type(JsonFieldType.NUMBER).description("설명 5"),
                fieldWithPath("data.pageable.pageSize").type(JsonFieldType.NUMBER).description("설명 6"),
                fieldWithPath("data.pageable.paged").type(JsonFieldType.BOOLEAN).description("설명 7"),
                fieldWithPath("data.pageable.unpaged").type(JsonFieldType.BOOLEAN).description("설명 8"),
                fieldWithPath("data.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지의 수"),
                fieldWithPath("data.totalElements").type(JsonFieldType.NUMBER).description("10"),
                fieldWithPath("data.last").type(JsonFieldType.BOOLEAN).description("설명 11"),
                fieldWithPath("data.size").type(JsonFieldType.NUMBER).description("한 페이지의 크기"),
                fieldWithPath("data.number").type(JsonFieldType.NUMBER).description("현재 페이지 정보"),
                fieldWithPath("data.sort").type(JsonFieldType.OBJECT).description("설명 14"),
                fieldWithPath("data.sort.empty").type(JsonFieldType.BOOLEAN).description("설명 15"),
                fieldWithPath("data.sort.sorted").type(JsonFieldType.BOOLEAN).description("설명 16"),
                fieldWithPath("data.sort.unsorted").type(JsonFieldType.BOOLEAN).description("설명 17"),
                fieldWithPath("data.numberOfElements").type(JsonFieldType.NUMBER).description("결과 데이터 수"),
                fieldWithPath("data.first").type(JsonFieldType.BOOLEAN).description("첫 페이지 여부"),
                fieldWithPath("data.empty").type(JsonFieldType.BOOLEAN).description("설명 20")));

        return fieldDescriptors;
    }

}
