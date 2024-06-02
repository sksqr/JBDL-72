package com.gfg;

public class AbstractClassAndInterfaceDemo {

    public static void main(String[] args) {
        System.out.println(InterfaceDemo.companyName
        );

        //InterfaceDemo.companyName = "Paytm";
        //AbstractClass.data;

        ConcreteClass concreteClass = new ConcreteClass();
        System.out.println(concreteClass.getData());
        System.out.println(concreteClass.getNewData());
    }
}

abstract class AbstractClass{

    private String data;

    public String getData(){
        return "Getting data form AbstractClass";
    }

    private String getDataInternal(){
        return "";
    }

    public abstract String getDetails();

}

class ConcreteClass extends  AbstractClass implements InterfaceDemo{

    @Override
    public String getDetails() {
        return null;
    }

    @Override
    public String getData(){
        return "Getting data form ConcreteClass";
    }
}

interface InterfaceDemo {
    String companyName = "GFG";
    default public String getData(){
        return "Getting data form InterfaceDemo";
    }


    default public String getNewData(){
        return "Getting getNewData form InterfaceDemo";
    }

}