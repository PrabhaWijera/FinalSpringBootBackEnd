package com.example.prabhash.vehicelserver.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseController {

    private int StatusCode;
    private String message;
    private Object data;
}
