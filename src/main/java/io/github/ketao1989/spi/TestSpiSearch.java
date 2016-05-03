/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: kxcoder Date: 15-9-28 Time: 下午3:49
 * @version: \$Id\$
 */
public class TestSpiSearch {

    public static void main(String[] args) {

        ISpiSearch search = null;

        ServiceLoader<ISpiSearch> spiSearches = ServiceLoader.load(ISpiSearch.class);

        Iterator<ISpiSearch> spiSearch = spiSearches.iterator();

        if (spiSearch.hasNext()){
            search = spiSearch.next();
        }

        System.out.println(search.search("key:search"));

    }
}
