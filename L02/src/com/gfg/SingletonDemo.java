package com.gfg;

public class SingletonDemo {

    public static void main(String[] args) {

//     SingletonClass obj1 = new SingletonClass();
//        SingletonClass obj2 = new SingletonClass();

        SingletonClass obj1 =  SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();

        System.out.println(obj1 == obj2);

//        SingletonClassEnum singletonClassEnum = new SingletonClassEnum();
        SingletonClassEnum singletonClassEnum = SingletonClassEnum.SingleObject;
    }
}

enum SingletonClassEnum{

    SingleObject("testData");

    private SingletonClassEnum(String data) {
        this.data = data;
    }

    private String data;

    public String getData() {
        return data;
    }

}


class SingletonClass{
    private String data;

    private static SingletonClass instance = new SingletonClass();

    public String getData() {
        return data;
    }

    private SingletonClass() {
    }

    public static SingletonClass getInstance(){
        return instance;
       // return new SingletonClass();
    }

    public void setData(String data) {
        this.data = data;
    }
}
