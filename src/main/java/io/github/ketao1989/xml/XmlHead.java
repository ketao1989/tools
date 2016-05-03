/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.xml;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tao.ke Date: 15/11/24 Time: 下午2:53
 * @version \$Id$
 */
public class XmlHead implements Serializable {

    private static final long serialVersionUID = 452748676813717826L;

    private int version;

    private String org;

    public XmlHead() {
    }

    public XmlHead(int version, String org) {
        this.version = version;
        this.org = org;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
