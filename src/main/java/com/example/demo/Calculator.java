package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filepath) throws IOException {
        /*
        filePath 를 읽어서 BufferReader 를 만드는 템플릿 로직과 line 을 읽어서 더하는 콜백로직을 분리
         */
        BufferedReaderCallback sumCallback = new BufferedReaderCallback() {

            /**
             * br 을 이용해 line 을 읽어서 더하여 결과를 반환하는 메서드
             */
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer sum = 0;
                String line = null;
                while ((line = br.readLine()) != null) {
                    sum += Integer.valueOf(line);
                }
                return sum;
            }

        };

        return fileReadTemplate(filepath, sumCallback);
    }

    /**
     * filePath 를 받아서 BufferReader 를 만들고, callback 객체를 받아서 뭔가 처리하게 하는 메소드
     */
    public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            // filepath 를 받아서 BufferReader 를 만든다
            br = new BufferedReader(new FileReader(filePath));
            // callback 객체의 doSomethingWithReader 를 수행해서 결과를 받는다
            int ret = callback.doSomethingWithReader(br);
            return ret;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
