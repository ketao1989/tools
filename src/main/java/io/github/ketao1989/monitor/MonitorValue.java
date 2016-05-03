/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.monitor;

import java.io.Serializable;

/**
 * @author tao.ke Date: 15/7/26 Time: 上午11:44
 * @version \$Id$
 */
public class MonitorValue implements Serializable {

    private static final long serialVersionUID = -1542615639071516343L;
    /**
     * 时间
     */
    private long time;

    /**
     * 次数
     */
    private long count;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void add(final long time,final long count){
        this.time += time;
        this.count += count;
    }

}
