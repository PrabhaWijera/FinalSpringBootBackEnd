package com.example.prabhash.paymentserver.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsController {

    private int StatusCode;
    private String message;
    private Object data;
}
