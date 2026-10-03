package com.github.felipemartins152.consolidator.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtils {

    private static final ZoneId ZONE = ZoneId.of("America/Sao_Paulo");

    private DateTimeUtils(){}

    public static LocalDateTime now(){
        return LocalDateTime.now(ZONE);
    }

}