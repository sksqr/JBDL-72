package com.gfg.diamondproblem;

public class ClassCWithInterfaces implements InterfaceA, InterfaceB{
    @Override
    public void walk() {
        System.out.println("walk C");
    }
}
