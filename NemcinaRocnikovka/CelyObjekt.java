package com.example.rocnikovkanemcinaalfa_1_1;

public class CelyObjekt extends HelloApplication {
    public CelyObjekt(int poradi, String cesky,String nemecky, String nemeckyMinule, String pravidelnost) {
        this.poradi = poradi;
        this.cesky = cesky;
        this.nemecky = nemecky;
        this.nemeckyMinule = nemeckyMinule;
        this.pravidelnost = pravidelnost;
    }

    @Override
    public String toString() {
        return  "cesky='" + cesky + '\'' +
                ", nemeckyMinule='" + nemeckyMinule + '\'';
    }
}