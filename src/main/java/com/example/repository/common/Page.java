package com.example.repository.common;

import lombok.Data;

@Data
public class Page {
    private Integer current;
    private Integer size;
    private Integer total;
    private Object data;

    public Page(Integer current, Integer size, Integer total, Object data) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.data = data;
    }
}
