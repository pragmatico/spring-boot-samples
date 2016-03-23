package com.example.common;

import javax.validation.Valid;
import java.util.List;

public class ValidatableBeanList<T> {

    @Valid
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
