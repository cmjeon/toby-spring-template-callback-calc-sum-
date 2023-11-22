package com.example.demo.callback;

public interface GenericsLineCallback<T> {

    T doSomethingWithLine(String line, T value);

}
