package com.project.DisasterRecovery.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class errorMessage {
    private Date timestamp;
    private String message;
    private String details;

}
