package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

/**
 * @author rocker
 * @date 2021/12/10 15:18
 */
@Slf4j
public class MDCDemo {

    private static final String TRACE_ID = "TRACE_ID";

    @Test
    public void testMdc1() {
        MDC.put(TRACE_ID, UUID.randomUUID().toString());
        log.info("log in main method");
    }

    @Test
    public void testMdc2() {
        MDC.put(TRACE_ID, UUID.randomUUID().toString());
        log.info("log in main method");
        nestMethod();
    }

    private void nestMethod() {
        log.info("log in nest method");
    }

    @Test
    public void testMdc3() throws IOException {
        new Thread(() -> {
            MDC.put(TRACE_ID, UUID.randomUUID().toString());
            log.info("log in thread1 start");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("log in thread1 end");
        }).start();

        new Thread(() -> {
            MDC.put(TRACE_ID, UUID.randomUUID().toString());
            log.info("log in thread2 start");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("log in thread2 end");
        }).start();

        System.in.read();
    }

}
