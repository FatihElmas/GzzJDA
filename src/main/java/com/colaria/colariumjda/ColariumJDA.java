package com.colaria.colariumjda;

import com.colaria.colariumjda.command.CommandHandler;
import net.dv8tion.jda.api.JDA;

public class ColariumJDA {
    private String owner;

    public ColariumJDA(JDA jda) {
        jda.addEventListener(new CommandHandler());
    }

    public ColariumJDA setOwner(String id) {
        this.owner = id;
        return this;
    }
}
