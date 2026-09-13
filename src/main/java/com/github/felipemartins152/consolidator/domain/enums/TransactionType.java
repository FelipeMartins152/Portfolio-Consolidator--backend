package com.github.felipemartins152.consolidator.domain.enums;

public enum TransactionType {

    BUY,
    SELL;

    public static TransactionType ofText(String text){
        if(text == null) return null;

        String t = text.toUpperCase();

        return TransactionType.valueOf(t);
    }

}
