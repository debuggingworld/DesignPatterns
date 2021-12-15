package com.zth.designPatterns.chainofResponsibility;

/**
 * @author 猫和少年
 * @create 2021-12-15 21:52
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 * 责任链设计模式
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOK(true).loggedOn(false).build();

        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));

        if (requestFrequentHandler.process(request)) {
            System.out.println("业务正常处理");
        }else {
            System.out.println("访问异常");
        }

    }
}



