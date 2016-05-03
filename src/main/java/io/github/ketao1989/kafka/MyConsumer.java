/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.kafka;

import kafka.javaapi.consumer.SimpleConsumer;

/**
 * @author tao.ke Date: 16/4/14 Time: 下午5:23
 */
public class MyConsumer extends SimpleConsumer {

  public MyConsumer(String host, int port, int soTimeout, int bufferSize,
                    String clientId) {
    super(host, port, soTimeout, bufferSize, clientId);
  }
}
