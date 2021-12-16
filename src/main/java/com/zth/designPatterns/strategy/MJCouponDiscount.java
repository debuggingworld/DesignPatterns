package com.zth.designPatterns.strategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author 猫和少年
 * @create 2021-12-16 22:32
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class MJCouponDiscount implements CouponDiscount<Map<String, String>> {

    /**
     * 满减计算
     * 1. 判断满⾜x元后-n元，否则不减
     * 2. 最低⽀付⾦额1元
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String condition = couponInfo.get("condition");
        String amount = couponInfo.get("amount");
        // ⼩于商品⾦额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(condition)) < 0) return skuPrice;
        // 减去优惠⾦额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(amount));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return
                BigDecimal.ONE;
        return discountAmount;
    }
}
