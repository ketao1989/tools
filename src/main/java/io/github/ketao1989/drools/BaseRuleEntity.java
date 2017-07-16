/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tao.ke Date: 16/5/25 Time: 上午10:47
 */
public class BaseRuleEntity {

    private boolean checked;

    public static final Logger logger = LoggerFactory.getLogger("drools.execute.log");

    public boolean isChecked() {
        return checked;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Logger getLogger() {
        return logger;
    }

}
