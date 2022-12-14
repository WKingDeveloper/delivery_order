package com.example.order.controller.user;

import com.example.order.model.response.Response;
import com.example.order.model.user.UserSignUpRequestDto;
import com.example.order.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public Response join(@Valid @RequestBody UserSignUpRequestDto request) {
        log.debug("UserController -> join()");
        return userService.signUp(request);
    }

}
