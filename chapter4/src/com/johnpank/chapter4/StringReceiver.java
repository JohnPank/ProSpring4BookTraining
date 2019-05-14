package com.johnpank.chapter4;

public class StringReceiver {

    private StringGeter stringGeter;

    StringReceiver(StringGeter stringGeter){
        this.stringGeter = stringGeter;
    }

    public void showString(){
        System.out.println(stringGeter.getString());
    }

}
