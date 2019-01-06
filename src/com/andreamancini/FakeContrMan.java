package com.andreamancini;

import java.util.ArrayList;

abstract class FakeContrMan {

    static FakeCont[] plug(int num){

        ArrayList<FakeCont> list = new ArrayList<>();

        for (int i = 1; i <= num; i++){

            FakeCont fc = new FakeCont();

            fc.name = "joy " + i;
            fc.type = "Stick";

            list.add(fc);

        }

        return list.toArray(new FakeCont[0]);

    }
}
