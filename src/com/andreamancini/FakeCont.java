package com.andreamancini;

class FakeCont {

     String name;
     String type;
     private float x;
     private float y;
     private float z;
     private int trendx;
     private int trendy;
     private int trendz;


    FakeCont(){

        this.name = "";
        this.type = "";
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.trendx = 1;
        this.trendy = 1;
        this.trendz = 1;

    }


    String getName(){

        return name;
    }

    String getType(){
        return type;
    }

    float getX(){
        return x;
    }
    float getY(){
        return y;
    }
    float getZ(){
        return z;
    }


    void move(String ax, float inc){


        switch (ax){

            case "x":
                if(trendx == 1){
                    if(x >= 1.0f) {
                        x = x - inc;
                        trendx = -1;

                    }else{
                        x = x + inc;
                    }
                }else if(trendx == -1){
                    if(x <= -1.0f) {
                        x = x + inc;
                        trendx = 1;
                    }else {
                        x = x - inc;
                    }
                }

                break;

            case "y":
                if(trendy == 1){
                    if(y >= 1.0f) {
                        y = y - inc;
                        trendy = -1;

                    }else{
                        y = y + inc;
                    }
                }else if(trendy == -1){
                    if(y <= -1.0f) {
                        y = y + inc;
                        trendy = 1;
                    }else {
                        y = y - inc;
                    }
                }

                break;

            case "z":
                if(trendz == 1){
                    if(z >= 1.0f) {
                        z = z - inc;
                        trendz = -1;

                    }else{
                        z = z + inc;
                    }
                }else if(trendz == -1){
                    if(z <= -1.0f) {
                        z = z + inc;
                        trendz = 1;
                    }else {
                        z = z - inc;
                    }
                }

                break;
        }

    }




}
