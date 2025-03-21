package be.naaturel.letsmeet.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Result<T> {

    private T value;

    public Result(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
