package org.academiadecodigo.codezillas.entities;

public class PoliceFactory {


    public static Police[] createPolices() {
        Police[] police = new Police[10];

        for (int i = 0; i < police.length; i++) {
            police[i] = new Police();
            police[i].create();
        }
        return police;
    }

}
