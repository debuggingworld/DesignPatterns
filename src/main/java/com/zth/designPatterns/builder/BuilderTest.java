package com.zth.designPatterns.builder;

/**
 * @author 猫和少年
 * @create 2022-03-26 22:21
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director(new DefaultConcreteProductBuilder());
        Product product = director.makeProduct("name", "company", "xxx1", "xxx2", "xxx3", "xxx4");

        System.out.println(product);
    }
}

interface ProductBuilder {
    void buildProductName(String productName);

    void buildCompany(String company);

    void buildPart1(String part1);

    void buildPart2(String part2);

    void buildPart3(String part3);

    void buildPart4(String part4);

    Product build();
}

class Director {
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4) {
        builder.buildProductName(productName);
        builder.buildCompany(companyName);
        builder.buildPart1(part1);
        builder.buildPart2(part2);
        builder.buildPart3(part3);
        builder.buildPart4(part4);

        return builder.build();
    }
}


class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String company;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void buildProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildCompany(String company) {
        this.company = company;
    }

    @Override
    public void buildPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void buildPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void buildPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void buildPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName, this.company, this.part1, this.part2, this.part3, this.part4);
    }
}


class Product {
    private String productName;
    private String company;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product() {
    }

    public Product(String productName, String company, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.company = company;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
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