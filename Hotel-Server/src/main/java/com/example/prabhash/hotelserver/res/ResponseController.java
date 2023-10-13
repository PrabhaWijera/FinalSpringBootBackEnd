package com.example.prabhash.hotelserver.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseController {

    private int stateCode;

    private String message;

    private Object data;
}
