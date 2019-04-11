package com.onisq.phez;

public class Experience  {
    long exp = 0;
    long hint = 5;

    public long getExp() {
        return exp;
    }
    public long getHint() {
        return hint;
    }

    void earnIron(){
        exp+=50;
        hint+=1;
    }
    void earnBronze(){
        exp+=100;
        hint+=2;
    }
    void earnSilver(){
        exp+=175;
        hint+=3;
    }
    void earnGold(){
        exp+=250;
        hint+=4;
    }
    void earnPlatinum(){
        exp+=500;
        hint+=5;
    }
    void earnDiamond(){
        exp+=1000;
        hint+=10;
    }

    void useHint(){
        hint--;
    }
}
