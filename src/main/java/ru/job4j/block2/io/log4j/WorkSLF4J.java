package ru.job4j.block2.io.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkSLF4J {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean bool = false;
        byte b = 1;
        short shortt = 2;
        int i = 3;
        long l = 4;
        double doubl = 5.5;
        float floatt = 6.5F;
        char c = '+';
        LOG.debug("primitives : {}, {}, {}, {}, {}, {}, {}, {}",
                bool, b, shortt, i, l, doubl, floatt, c);
    }
}
