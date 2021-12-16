package com.zth.designPatterns.strategy;

import java.math.BigDecimal;

/**
 * @author 猫和少年
 * @create 2021-12-16 22:34
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class ZKCouponDiscount implements CouponDiscount<Double> {

    /**
     * 折扣计算
     * 1. 使⽤商品价格乘以折扣⽐例，为最后⽀付⾦额
     * 2. 保留两位⼩数
     * 3. 最低⽀付⾦额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {

        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).
                setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ONE) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
