package io.github.ketao1989.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author tao.ke Date: 2017/12/31 Time: 上午1:07
 */
public class BlogOth implements Serializable {

  private static final long serialVersionUID = 3669472283266271710L;

  private String id;
  private String name;

  public String getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}