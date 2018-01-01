package io.github.ketao1989.dubbo.api;

import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tao.ke Date: 2018/1/1 Time: 下午11:18
 */
public class UserRequest implements Serializable{

  private long id;

  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ToStringBuilder
        .reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

  public static void main(String[] args) {
    UserRequest userRequest = new UserRequest();
    userRequest.setId(1234567);
    userRequest.setName("kk123");

    System.out.println(JSON.toJSONString(userRequest));
  }
}
