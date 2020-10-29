package com.colaria.colariumjda.command;

import net.dv8tion.jda.api.Permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandParams {

    char prefix();
    String[] aliases();
    String name();
    Permission[] permissions() default {};

}
