package sms.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static final AtomicInteger nextId = new AtomicInteger(1000);

    public static int generateId() {
        return nextId.getAndIncrement();
    }

    public static void reset() {
        nextId.set(1000);
    }
}