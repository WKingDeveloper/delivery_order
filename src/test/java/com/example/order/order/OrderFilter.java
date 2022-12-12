package com.example.order.order;

import com.example.order.doc.CommonFilter;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.restassured3.RestDocumentationFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;

public class OrderFilter {
    CommonFilter commonFilter = new CommonFilter();
    List<FieldDescriptor> responseFields = new ArrayList<>();

    public RestDocumentationFilter getOrdersSuccessFilter(String identifier) {
        responseFields = commonFilter.setPagingFilter(responseFields);

        return document(identifier,
                requestParameters(
                        setOrdersRequestParameters()
                ),
                responseFields(
                        setOrdersResponseFields(responseFields)
                )
        );
    }

    public RestDocumentationFilter updateOrderAddressSuccessFilter(String identifier) {
        return document(identifier,
                requestParameters(
                        parameterWithName("id").description("주문 아이디"),
                        parameterWithName("baseAddress").description("변경할 기본 주소"),
                        parameterWithName("detailAddress").description("변경할 상세 주소")
                ),
                responseFields(
                        fieldWithPath("code").type(JsonFieldType.STRING).description("응답 코드"),
                        fieldWithPath("error").type(JsonFieldType.STRING).description("에러 메시지").optional(),
                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("응답 결과 데이터"),
                        fieldWithPath("data.orderId").type(JsonFieldType.NUMBER).description("주문 아이디"),
                        fieldWithPath("data.beforeAddress").type(JsonFieldType.OBJECT).description("이전 주소"),
                        fieldWithPath("data.beforeAddress.baseAddress").type(JsonFieldType.STRING).description("이전 기본 주소"),
                        fieldWithPath("data.beforeAddress.detailAddress").type(JsonFieldType.STRING).description("이전 상세 주소"),
                        fieldWithPath("data.afterAddress").type(JsonFieldType.OBJECT).description("변경 주소"),
                        fieldWithPath("data.afterAddress.baseAddress").type(JsonFieldType.STRING).description("변경한 기본 주소"),
                        fieldWithPath("data.afterAddress.detailAddress").type(JsonFieldType.STRING).description("변경한 상세 주소")

                        )
        );
    }

    List<ParameterDescriptor> setOrdersRequestParameters() {
        List<ParameterDescriptor> parameterDescriptors = new ArrayList<>();
        parameterDescriptors.addAll(Arrays.asList(
                parameterWithName("page").description("페이지 번호"),
                parameterWithName("size").description("페이지 당 출력 상품 개수")
        ));
        return parameterDescriptors;
    }

    List<FieldDescriptor> setOrdersResponseFields(List<FieldDescriptor> fieldDescriptors) {
        fieldDescriptors.addAll(Arrays.asList(
                fieldWithPath("code").type(JsonFieldType.STRING).description("응답 코드"),
                fieldWithPath("error").type(JsonFieldType.STRING).description("에러 메시지").optional(),
                fieldWithPath("data").type(JsonFieldType.OBJECT).description("응답 결과 데이터").optional(),
                fieldWithPath("data.content").type(JsonFieldType.ARRAY).description("응답 결과 데이터 묶음"),
                fieldWithPath("data.content.[].id").type(JsonFieldType.NUMBER).description("주문 아이디"),
                fieldWithPath("data.content.[].createdAt").type(JsonFieldType.STRING).description("주문 생성 일시"),
                fieldWithPath("data.content.[].updatedAt").type(JsonFieldType.STRING).description("주문 수정 일시"),
                fieldWithPath("data.content.[].address").type(JsonFieldType.OBJECT).description("주소"),
                fieldWithPath("data.content.[].address.baseAddress").type(JsonFieldType.STRING).description("기본 주소"),
                fieldWithPath("data.content.[].address.detailAddress").type(JsonFieldType.STRING).description("상세 주소"),
                fieldWithPath("data.content.[].paymentStatus").type(JsonFieldType.STRING).description("결제 상태"),
                fieldWithPath("data.content.[].platform").type(JsonFieldType.STRING).description("플랫폼 종류"),
                fieldWithPath("data.content.[].request").type(JsonFieldType.STRING).description("요청 사항"),
                fieldWithPath("data.content.[].price").type(JsonFieldType.NUMBER).description("주문 가격"),
                fieldWithPath("data.content.[].status").type(JsonFieldType.STRING).description("배송 상태"),
                fieldWithPath("data.content.[].phoneNumber").type(JsonFieldType.STRING).description("전화번호"),
                fieldWithPath("data.content.[].editAble").type(JsonFieldType.BOOLEAN).description("수정 가능 여부"),
                fieldWithPath("data.content.[].issued").type(JsonFieldType.BOOLEAN).description("배차 확정 여부")

        ));
        return fieldDescriptors;
    }

}
