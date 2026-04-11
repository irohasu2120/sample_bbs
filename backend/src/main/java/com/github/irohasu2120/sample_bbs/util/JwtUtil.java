package com.github.irohasu2120.sample_bbs.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
//TODO リフレッシュトークンの発行をしてみたい
public class JwtUtil {
    // FIXME 鍵は外部ファイルに置くのがベター？
    // HS256による署名方式
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
                // JWT生成
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
            // JWTの解析
            String subject =
                    Jwts.parser()
                            // 署名が生成時の物と同一か検証
                            .verifyWith(key)
                            // JwtParaserインスタンスの生成
                            .build()
                            // 署名の正当性と標準クレームを検証
                            .parseSignedClaims(token)
                            // ペイロードを取得
                            .getPayload()
                            // ペイロードのsubを取得
                            .getSubject();
            return Optional.ofNullable(subject);
        } catch (JwtException e) {
            // JWTが検証エラーと判定した場合の処理
            return Optional.empty();
        }
    }
}
