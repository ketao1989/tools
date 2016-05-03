/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.spi.impl;

import io.github.ketao1989.spi.ISpiSearch;

/**
 * @author: kxcoder Date: 15-9-28 Time: 下午3:47
 * @version: \$Id\$
 */
public class SpiStringSearch implements ISpiSearch {

    public String search(String key) {

        return "search " + key + " ok. from string method.";
    }
}
