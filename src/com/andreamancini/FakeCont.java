package com.andreamancini;

class FakeCont {

     String name;
     String type;
     private float x;
     private float y;
     private float z;
     private int trend;

    FakeCont(){

        this.name = "";
        this.type = "";
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.trend = 1;

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
                if(trend == 1){
                    if(x >= 1) {
                        this.x = x - inc;
                        this.trend = -1;

                    }else{
                        this.x = x + inc;
                    }
                }else if(trend == -1){
                    if(x <= -1) {
                        this.x = x + inc;
                        this.trend = 1;
                    }else {
                        this.x = x - inc;
                    }
                }

                break;

            case "y":
                if(trend == 1){
                    if(y >= 1.0f) {
                        this.y = y - inc;
                        trend = -1;
                    }else{
                        this.y = y + inc;
                    }
                }else if(trend == -1){
                    if(y <= 1) {
                        this.y = y + inc;
                        trend = 1;
                    }else {
                        this.y = y - inc;
                    }
                }

                break;

            case "z":
                if(trend == 1){
                    if(z >= 1) {
                        this.z = z - inc;
                        trend = -1;
                    }else{
                        this.z = z + inc;
                    }
                }else if(trend == -1){
                    if(z <= 1) {
                        this.z = z + inc;
                        trend = 1;
                    }else {
                        this.z = z - inc;
                    }
                }

                break;
        }

    }




}
