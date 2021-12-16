package com.zth.designPatterns.strategy;

import java.math.BigDecimal;

/**
 * @author 猫和少年
 * @create 2021-12-16 22:31
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public interface CouponDiscount<T> {

    /**
     * 优惠券金额计算
     * @param couponInfo 优惠券信息
     * @param skuPrice skuji金额
     * @return   折扣金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}