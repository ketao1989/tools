/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.guice;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author: kxcoder Date: 15-9-14 Time: 下午3:16
 * @version: \$Id\$
 */

@ImplementedBy(GuiceServiceImpl.class)
public interface IGuiceService {

    public String sayHello(String name);
}
