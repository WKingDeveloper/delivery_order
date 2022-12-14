package com.example.order.service.user;

import com.example.order.model.response.ErrorResponseDto;
import com.example.order.model.response.ResponseDto;
import com.example.order.model.response.SuccessResponseDto;
import com.example.order.model.user.User;
import com.example.order.model.user.UserLoginRequestDto;
import com.example.order.model.user.UserSignUpRequestDto;
import com.example.order.provider.JwtTokenProvider;
import com.example.order.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    @Transactional
    public ResponseDto signUp(UserSignUpRequestDto requestDto){

        log.debug("UserService -> UserSignUpRequestDto()");
        if (userRepository.findByUserId(requestDto.getUserId()).isPresent()){
            return new ErrorResponseDto("401","이미 존재하는 아이디입니다.");
        }

        if (userRepository.findByBusinessNumber(requestDto.getBusinessNumber()).isPresent()){
            return new ErrorResponseDto("402","이미 존재하는 사업자 번호입니다.");
        }

        if (!requestDto.getPassword().equals(requestDto.getCheckedPassword())){
            return new ErrorResponseDto("403","비밀번호가 일치하지 않습니다.");
        }

        User user = userRepository.save(requestDto.toEntity());
        user.encodePassword(passwordEncoder);


        return new SuccessResponseDto("회원가입에 성공했습니다.");
    }

    @Transactional
    public ResponseDto signIn(UserLoginRequestDto users) {

        Optional<User> findUser = userRepository.findByUserId(users.getId());
        if(!findUser.isPresent()){
            return new ErrorResponseDto("410","아이디 혹은 비밀번호가 일치하지 않습니다.");
        }

        String password = users.getPassword();
        User user = findUser.get();
        if (!user.checkPassword(passwordEncoder, password)) {
            return new ErrorResponseDto("410","아이디 혹은 비밀번호가 일치하지 않습니다.");
        }

        List<String> roles = new ArrayList<>();
        roles.add(user.getRole().name());


        return new SuccessResponseDto(jwtTokenProvider.createToken(user.getUserId(), roles));
    }
}
