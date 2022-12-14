package com.example.order.model.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
public class UserSignUpRequestDto {

    @NotBlank(message = "아이디를 입력해주세요")
    private String userId;

    @NotBlank(message = "개인 전화 번호를 입력해주세요.")
    @Pattern(regexp = "\\d{11}",
            message = "-없이 11자리로 입력해주세요.")
    private String userPhoneNumber;

    @NotBlank(message = "사업자 등록번호를 입력해주세요")
    @Pattern(regexp = "\\d{10}",
            message = "-없이 10자리로 입력해주세요.")
    private String businessNumber;

    @NotBlank(message = "사업자 전화 번호를 입력해주세요.")
    @Pattern(regexp = "\\d{11}",
            message = "-없이 11자리로 입력해주세요.")
    private String businessPhoneNumber;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{12,20}$",
            message = "영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열로 생성해야합니다.")
    private String password;

    private String checkedPassword;

    @Builder
    public User toEntity(){
        return User.builder()
                .userId(userId)
                .userPhoneNumber(userPhoneNumber)
                .businessNumber(businessNumber)
                .businessPhoneNumber(businessPhoneNumber)
                .password(password)
                .role(Role.USER)
                .build();
    }
}
