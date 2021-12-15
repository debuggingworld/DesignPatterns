package com.zth.designPatterns.chainofResponsibility;

/**
 * @author 猫和少年
 * @create 2021-12-15 22:16
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler {


    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率验证");

        if (request.isFrequentOK()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            return next.process(request);
        }
        return false;
    }
}

class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录验证");

        if (request.isLoggedOn()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            return next.process(request);
        }
        return false;
    }
}