package com.oglcnkrty.enums;

import lombok.Getter;


public enum ErrorType {

    NO_RECORD_EXISTS("1004", "Kayıt Bulunamadı."),
    TOKEN_IS_EXPIRED("1005", "Tokenin süresi dolmuştur."),
    USER_DOES_NOT_EXIST("1006", "Kullanıcı bulunamadı."),
    USERNAME_PASSWORD_INVALID("1007", "Kullanıcı adı veya şifre geçersiz."),
    REFRESH_TOKEN_NOT_FOUND("1008", "Refresh token bulunamadı."),
    REFRESH_TOKEN_IS_EXPIRED("1009", "Refresh tokenin süresi dolmuştur."),
    GENERAL_EXCEPTION("9999", "Genel Bir Hata Oluştu.");

    private String code;
    private String message;

    ErrorType(String code, String Message) {
        this.code = code;
        this.message = Message;
    }


}
