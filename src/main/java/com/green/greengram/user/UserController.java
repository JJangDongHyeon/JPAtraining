package com.green.greengram.user;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.user.model.SignInPostReq;
import com.green.greengram.user.model.SignInPostRes;
import com.green.greengram.user.model.SignUpPostReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    public ResultDto<Integer> signUpPostReq(@RequestPart MultipartFile pic, @RequestPart SignUpPostReq p){
        int result = service.signUpPostReq(pic, p);
        return ResultDto.<Integer>builder()
                .resultMsg("회원가입 성공")
                .resultData(result).build();
    }

    @PostMapping("sign-in")
    public ResultDto<SignInPostRes> signInPost(@RequestBody SignInPostReq p) {
        SignInPostRes result = service.signInPost(p);

        return ResultDto.<SignInPostRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("로그인 성공")
                .resultData(result)
                .build();
    }
}
