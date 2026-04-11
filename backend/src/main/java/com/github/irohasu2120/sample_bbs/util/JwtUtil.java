package com.github.irohasu2120.sample_bbs.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

public class JwtUtil {
    private static final SecretKey key = Jwts.SIG.HS256.key().build();

    /**
     * JWT生成
     *
     * @param userName ユーザーID
     * @return JWT
     */
    public static String generateJwt(String userName) {
        return Jwts.builder()
                // 発行者
                .issuer("sasaki")
                // ユニーク情報
                .subject(userName)
                // 発行日時
                .issuedAt(new Date())
                // 有効期限を現在から24時間後
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                // 署名
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

    /**
     * JWT検証
     *
     * @param token JWT
     * @return 検証結果
     */
    public static Optional<String> validateAndGetSubject(String token) {
        if (StringUtils.isBlank(token)) {
            return Optional.empty();
        }
        try {
            String subject =
                    Jwts.parser()
                            .verifyWith(key)
                            .build()
                            .parseSignedClaims(token)
                            .getPayload()
                            .getSubject();
            return Optional.ofNullable(subject);
        } catch (JwtException e) {
            return Optional.empty();
        }
    }
}
