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

  private long id;
  private String name;
  private String content;
  private Timestamp createTime;

  public BlogOth(long id) {
    this.id = id;
    this.name="xxxxx";
  }

  public BlogOth(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }


  public String getName() {
    return name;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}