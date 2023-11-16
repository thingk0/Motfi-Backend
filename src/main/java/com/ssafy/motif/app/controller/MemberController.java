package com.ssafy.motif.app.controller;

import com.ssafy.motif.app.dto.member.LoginRequestDto;
import com.ssafy.motif.app.dto.member.SignupRequestDto;
import com.ssafy.motif.app.service.MemberService;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
        memberService.login(requestDto, response);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
