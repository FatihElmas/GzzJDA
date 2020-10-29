package com.colaria.colariumjda;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Test {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("NzYyNzI0ODc5NjY5MjY0NDI0.X3tU5g.tltNoqHd7A_22LgPBHezQCC9BFc").build();
        ColariumJDA cj = new ColariumJDA(jda)
                .setOwner("572027947184160786");

    }

}
