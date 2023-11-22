package com.example.demo.callback;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Callback 인터페이스
 */
public interface BufferedReaderCallback {

    Integer doSomethingWithReader(BufferedReader br) throws IOException;

}
