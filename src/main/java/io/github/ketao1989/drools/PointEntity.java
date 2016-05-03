/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;

/**
 * @author tao.ke Date: 16/4/15 Time: 下午2:57
 */
public class PointEntity {

  private long point;

  private int buyMoney;//fen

  private boolean birthdayMouth;

  public long getPoint() {
    return point;
  }

  public void setPoint(long point) {
    this.point = point;
  }

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
