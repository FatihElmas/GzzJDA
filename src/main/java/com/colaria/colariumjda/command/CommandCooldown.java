package com.colaria.colariumjda.command;

import net.dv8tion.jda.api.entities.User;
import java.util.HashMap;

public class CommandCooldown {
    private final HashMap<User, Long> timeMap = new HashMap<>();

    public void putInCooldown(User usr, int seconds) {
        timeMap.put(usr, System.currentTimeMillis() + (seconds * 1000L));
    }

    public boolean isOnCooldown(User usr) {
        return (timeMap.get(usr) != null && timeMap.get(usr) > System.currentTimeMillis());
    }

    public int getCooldownSeconds(User usr) {
        return (int)  ((timeMap.get(usr) - System.currentTimeMillis()) / 1000L);
    }
}
