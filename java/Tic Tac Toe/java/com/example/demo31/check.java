package com.example.demo31;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class check implements Runnable{
    String y;
    boolean res ;
    ArrayList<Button>  buttonList;
    public check(String y, ArrayList<Button> buttonList){
        this.y=y;
        this.buttonList = buttonList;
        this.res = false;
    }
    @Override
    public void run() {
        for (int j = 0; j <= 6; j = j + 3) {
            int p=0;
            for (int i = j; i <= j+2; i++) {
                if (!buttonList.get(i).getText().equals(y)) {
                    p=1;
                    break;
                }
            }
            if(p==0){
                res=true;
                return;
            }
        }
        for (int j = 0; j <= 2; j++) {
            int p=0;
            for (int i = j; i <= 8; i = i+3) {
                if (!buttonList.get(i).getText().equals(y)) {
                    p=1;
                    break;
                }
            }
            if(p==0){
                res=true;
                return;
            }
        }
        if (buttonList.get(0).getText().equals(y) && buttonList.get(4).getText().equals(y) && buttonList.get(8).getText().equals(y)) {
            this.res=true;
            return;
        }
        if (buttonList.get(2).getText().equals(y) && buttonList.get(4).getText().equals(y) && buttonList.get(6).getText().equals(y)) {
            this.res=true;
            return;
        }
        res=false;
    }
}
