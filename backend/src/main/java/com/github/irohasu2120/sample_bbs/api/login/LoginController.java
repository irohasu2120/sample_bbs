package com.github.irohasu2120.sample_bbs.api.login;

import com.github.irohasu2120.sample_bbs.api.login.model.LoginRequestBody;
import com.github.irohasu2120.sample_bbs.util.JwtUtil;
import org.apache.commons.lang3.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestBody requestBody) {
        //TODO IDとパスワードをDBから取得する
        if (Strings.CS.equals("sasaki", requestBody.getId()) && Strings.CS.equals("1qazxsw2", requestBody.getPassword())) {
            String token = JwtUtil.generateJwt(requestBody.getId());
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .body("ログイン成功");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("認証失敗");
    }
}
