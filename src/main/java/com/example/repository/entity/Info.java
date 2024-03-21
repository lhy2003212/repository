package com.example.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Info {
    private Integer id;
    private String content;
    @JsonFormat
    private LocalDateTime outTime;
    private String readStatus;
}
