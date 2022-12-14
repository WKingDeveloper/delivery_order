package com.example.order.controller.user;

import com.example.order.model.response.Response;
import com.example.order.model.user.UserSignUpRequestDto;
import com.example.order.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public Response join(@Valid @RequestBody UserSignUpRequestDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            Response response = new Response();
            response.setCode("400");
            response.setError(errors.toString());
            return response;
        }
        log.debug("UserController -> join()");
        return userService.signUp(request);
    }

}
