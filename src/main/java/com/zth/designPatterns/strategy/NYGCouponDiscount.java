package com.zth.designPatterns.strategy;

import java.math.BigDecimal;

/**
 * @author 猫和少年
 * @create 2021-12-16 22:33
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class NYGCouponDiscount implements CouponDiscount<Double> {
    /**
     * n 元购购买
     * 1. ⽆论原价多少钱都固定⾦额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}