package com.zth.designPatterns.chainofResponsibility;

/**
 * @author 猫和少年
 * @create 2021-12-15 21:54
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class Request {
    private boolean loggedOn;
    private boolean frequentOK;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOK, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOK = frequentOK;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOK;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn){
            this.loggedOn = loggedOn;
            return this;
        }
        RequestBuilder frequentOK(boolean frequentOK){
            this.frequentOK = frequentOK;
            return this;
        }
        RequestBuilder isPermits(boolean isPermits){
            this.isPermits = isPermits;
            return this;
        }
        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords){
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build(){
            return new Request(loggedOn,frequentOK,isPermits,containsSensitiveWords);
        }
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }

    public boolean isFrequentOK() {
        return frequentOK;
    }

    public void setFrequentOK(boolean frequentOK) {
        this.frequentOK = frequentOK;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public void setPermits(boolean permits) {
        isPermits = permits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }

    public void setContainsSensitiveWords(boolean containsSensitiveWords) {
        this.containsSensitiveWords = containsSensitiveWords;
    }
    }
