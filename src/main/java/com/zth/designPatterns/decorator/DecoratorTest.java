package com.zth.designPatterns.decorator;

/**
 * @author 猫和少年
 * @create 2022-03-14 22:56
 * @Slogan 才疏学浅，少年登科；满腹经纶，白发不第
 */


public class DecoratorTest {
    public static void main(String[] args) {
        FilterCamera filterCamera = new FilterCamera(new BeautyCamera(new CameraImpl()));
        filterCamera.photo();
    }
}

interface Camera{
    void photo();
}

class CameraImpl implements Camera{
    @Override
    public void photo() {
        System.out.println("拍照");
    }
}

abstract class CameraDecorator implements Camera{
    Camera camera;

    public CameraDecorator(Camera camera) {
        this.camera = camera;
    }
}


class BeautyCamera extends CameraDecorator{
    public BeautyCamera(Camera camera) {
        super(camera);
    }

    @Override
    public void photo() {
        camera.photo();
        System.out.println("美颜");
    }
}

class FilterCamera extends CameraDecorator{
    public FilterCamera(Camera camera) {
        super(camera);
    }

    @Override
    public void photo() {
        camera.photo();
        System.out.println("滤镜");
    }
}