package com.zth.designPatterns.builder.v2;

/**
 * @author 猫和少年
 * @create 2022-03-26 23:01
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class BuilderTest2 {
    
    public static void main(String[] args) {
        Product product = new Product.Builder().productName("name").company("xxx").part1("1yy").build();
        System.out.println(product);
    }
}

class Product {
    private final String productName;
    private final String company;
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;

    public Product(String productName, String company, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.company = company;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    static class Builder{
        private String productName;
        private String company;
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder productName(String productName){
            this.productName = productName;
            return this;
        }
        public Builder company(String company){
            this.company = company;
            return this;
        }
        public Builder part1(String part1){
            this.part1 = part1;
            return this;
        }
        public Builder part2(String part2){
            this.part2 = part2;
            return this;
        }
        public Builder part3(String part3){
            this.part3 = part3;
            return this;
        }
        public Builder part4(String part4){
            this.part4 = part4;
            return this;
        }

        public Product build(){
            return new Product(this.productName,this.company,this.part1,this.part2,this.part3,this.part4);
        }
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", company='" + company + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}