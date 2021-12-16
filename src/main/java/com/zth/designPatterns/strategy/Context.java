package com.zth.designPatterns.strategy;

import java.math.BigDecimal;

/**
 * Created by 10292815 on 2021/12/10.
 * 策略控制类
 */
public class Context<T> {
    private CouponDiscount<T> couponDiscount;

    public Context(CouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}