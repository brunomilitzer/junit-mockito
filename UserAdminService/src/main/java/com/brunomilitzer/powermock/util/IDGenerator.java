package com.brunomilitzer.powermock.util;

public final class IDGenerator {

    static int i;

    public static final int generateID() {

        return i++;
    }

}
