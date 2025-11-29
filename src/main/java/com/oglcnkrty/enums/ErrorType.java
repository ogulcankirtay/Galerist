package com.oglcnkrty.enums;


public enum ErrorType {
    GENERAL_EXCEPTION("9999", "Genel Bir Hata Oluştu."),
    NO_RECORD_EXISTS("1004", "Kayıt Bulunamadı."),
    TOKEN_IS_EXPIRED("1005", "Tokenin süresi dolmuştur."),
    USER_DOES_NOT_EXIST("1006", "Kullanıcı bulunamadı."),
    USERNAME_PASSWORD_INVALID("1007", "Kullanıcı adı veya şifre geçersiz."),
    REFRESH_TOKEN_NOT_FOUND("1008", "Refresh token bulunamadı."),
    REFRESH_TOKEN_IS_EXPIRED("1009", "Refresh tokenin süresi dolmuştur."),
    CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1010", "müşteri parası yeterli değil."),
    CURRENCY_RATES_IS_OCCURRED("1011", "Currency servisinde bir hata oluştu."),
    THIS_CAR_SOLED("1012", "Bu araç satılmıştır");

    private String code;
    private String message;

    ErrorType(String code, String Message) {
        this.code = code;
        this.message = Message;
    }


}
