package com.zth.designPatterns.Prototype;

import java.io.*;

/**
 * @author 猫和少年
 * @create 2022-04-10 22:12
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 * <p>
 * 如果对应的类中的字段为 8 种原生数据类型，或者8种原生数据类型的包装类型，或String，BigInteger
 * 则只需要实现Cloneable这个接口且覆盖Object.clone方法，即可利用jvm的克隆机制，完成对象的拷贝
 * 这种方式即是浅拷贝， 如果对应的类中数据为自定义数据类型，或者其他可变的数据类型（如Date,或者其
 * 他对象类型），要借助jvm的克隆机制完成数据的拷贝，则需要实现所有的对象字段的遍历拷贝，即是深拷贝
 */

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        BaseInfo baseInfo = new BaseInfo("debuggingWorld");
        Product product = new Product("part1", "part2", baseInfo);

        Product clone = product.clone();
        System.out.println("original: " + product);
        System.out.println("clone:  " + clone);
        product.getBaseInfo().setCompanyName("xxxx");
        System.out.println("original: " + product);
        System.out.println("clone:  " + clone);
    }
}

class BaseInfo implements Cloneable, Serializable {
    private String companyName;

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }

    @Override
    public String toString() {
        return hashCode() + " ]BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}


class Product implements Cloneable, Serializable {

    static final long serialVersionUID = 6772397503790075095L;

    private String part1;
    private String part2;
    /**
     * 自定义数据类型
     */
    private BaseInfo baseInfo;

    public Product(String part1, String part2, BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.baseInfo = baseInfo;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }


    @Override
    protected Product clone() throws CloneNotSupportedException {
        // 利用jvm克隆机制完成的深拷贝
//        Product productClone= ((Product) super.clone());
//        BaseInfo clone1=this.baseInfo.clone();
//        productClone.setBaseInfo( clone1 );
//        return productClone ;

        // 序列化方式实现的深拷贝
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        try (ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)) {
            return ((Product) ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
