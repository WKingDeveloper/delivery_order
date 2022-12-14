package com.example.order.service.user;

import com.example.order.model.response.Response;
import com.example.order.model.user.User;
import com.example.order.model.user.UserSignUpRequestDto;
import com.example.order.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Transactional
    public Response signUp(UserSignUpRequestDto requestDto){
        Response response = new Response();
        log.debug("UserService -> UserSignUpRequestDto()");
        if (userRepository.findByUserId(requestDto.getUserId()).isPresent()){
            response.setCode("401");
            response.setError("이미 존재하는 이메일입니다.");
            return response;
        }

        if (userRepository.findByBusinessNumber(requestDto.getBusinessNumber()).isPresent()){
            response.setCode("402");
            response.setError("이미 존재하는 사업자 번호입니다.");
            return response;
        }


        if (!requestDto.getPassword().equals(requestDto.getCheckedPassword())){
            response.setCode("403");
            response.setError("비밀번호가 일치하지 않습니다.");
            return response;
        }

        User user = userRepository.save(requestDto.toEntity());
        user.encodePassword(passwordEncoder);

        response.setData("회원가입에 성공했습니다.");

        return response;
    }

}
