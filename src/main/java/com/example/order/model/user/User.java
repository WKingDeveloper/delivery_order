package com.example.order.model.user;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 사용자 아이디
     */
    private String userId;

    /**
     * 사용자 비밀번호
     */
    private String password;

    /**
     * 사용자 권한
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * 사용자 전화번호
     */
    private String userPhoneNumber;

    /**
     * 사업자 등록번호
     */
    private String businessNumber;

    /**
     * 사용자 전화번호
     */
    private String businessPhoneNumber;


    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
