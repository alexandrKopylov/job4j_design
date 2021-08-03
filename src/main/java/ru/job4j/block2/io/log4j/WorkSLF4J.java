package ru.job4j.block2.io.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkSLF4J {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean BOOLEAN = false;
        byte BYTE = 1;
        short SHORT = 2;
        int INT = 3;
        long LONG = 4;
        double DOUBLE = 5.5;
        float FLOAT = 6.5F;
        char CHAR = '+';
        LOG.debug("primitives : {}, {}, {}, {}, {}, {}, {}, {}",
                BOOLEAN, BYTE, SHORT, INT, LONG, DOUBLE, FLOAT, CHAR);
    }
}
