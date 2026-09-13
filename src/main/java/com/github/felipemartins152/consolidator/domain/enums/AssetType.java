package com.github.felipemartins152.consolidator.domain.enums;

public enum AssetType {

    STOCK,
    FII,
    CRYPTO;

    public static AssetType ofText(String text){
        if(text == null) return null;

        String t = text.toUpperCase();

        return AssetType.valueOf(t);
    }

}