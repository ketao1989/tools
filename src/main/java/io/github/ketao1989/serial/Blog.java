package io.github.ketao1989.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: zinian Date: 2016/12/6 Time: 下午9:32
 * @version: \$Id$
 */
public class Blog implements Serializable {

    private static final long serialVersionUID = 3669472283266271710L;

    private final long id;
    private final String name;
    private String content;
    private Timestamp createTime;

    public Blog(long id) {
        this.id = id;
        this.name="xxxxx";
    }

    public Blog(long id, String name) {
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
