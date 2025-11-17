package com.oglcnkrty.exception;

import com.oglcnkrty.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private ErrorType errorType;
    private String ofStatic;

    public String prepareErrorMessage() {
        StringBuilder message = new StringBuilder();
        message.append(errorType.toString());

        if (ofStatic != null) message.append(" : ").append(ofStatic);

        return message.toString();
    }
}
