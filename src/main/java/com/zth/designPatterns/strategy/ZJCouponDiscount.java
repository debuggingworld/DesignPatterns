package com.zth.designPatterns.strategy;

import java.math.BigDecimal;

/**
 * @author 猫和少年
 * @create 2021-12-16 22:33
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class ZJCouponDiscount implements CouponDiscount<Double> {
    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低⽀付⾦额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));

        if (discountAmount.compareTo(BigDecimal.ONE) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}