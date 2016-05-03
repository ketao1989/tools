/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tao.ke Date: 15/11/24 Time: 下午2:35
 * @version \$Id$
 */
public class XmlSampleNode implements Serializable {

    private static final long serialVersionUID = 8959736739158830644L;

    @JacksonXmlProperty(localName = "Head")
    private XmlHead head;

    private String name;

    private int age;

    private boolean isChinese;

    public XmlHead getHead() {
        return head;
    }

    public void setHead(XmlHead head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsChinese() {
        return isChinese;
    }

    public void setIsChinese(boolean isChinese) {
        this.isChinese = isChinese;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
