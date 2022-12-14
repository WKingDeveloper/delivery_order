package com.example.order.controller.user;

import com.example.order.model.response.ErrorResponseDto;
import com.example.order.model.response.ResponseDto;
import com.example.order.model.user.UserLoginRequestDto;
import com.example.order.model.user.UserSignUpRequestDto;
import com.example.order.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto join(@Valid @RequestBody UserSignUpRequestDto request, BindingResult bindingResult) {
        log.debug("UserController -> join()");
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            return new ErrorResponseDto("400",errors.toString());
        }
        return userService.signUp(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto login(@Valid @RequestBody UserLoginRequestDto request, BindingResult bindingResult) {
        log.debug("UserController -> login()");
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            return new ErrorResponseDto("400",errors.toString());
        }
        return userService.signIn(request);
    }

}
