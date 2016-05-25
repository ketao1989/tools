/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;

/**
 * @author tao.ke Date: 16/5/25 Time: 上午10:45
 */
public class PointParams extends BaseRuleEntity{

    private int buyMoney;//fen

    private boolean birthdayMouth;

    public int getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(int buyMoney) {
        this.buyMoney = buyMoney;
    }

    public boolean isBirthdayMouth() {
        return birthdayMouth;
    }

    public void setBirthdayMouth(boolean birthdayMouth) {
        this.birthdayMouth = birthdayMouth;
    }
}
