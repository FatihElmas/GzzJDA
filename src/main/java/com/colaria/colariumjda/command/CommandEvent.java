package com.colaria.colariumjda.command;

import net.dv8tion.jda.api.entities.*;

public class CommandEvent {
    private final TextChannel channel;
    private final Message message;
    private final String[] args;
    private final User user;
    private final Guild guild;
    private final Member member;
    private final int cooldown;

    public CommandEvent(TextChannel channel, Message message, String[] args, User user, Guild guild, Member member, int cooldown) {
        this.channel = channel;
        this.message = message;
        this.args = args;
        this.user = user;
        this.guild = guild;
        this.member = member;
        this.cooldown = cooldown;
    }

    public TextChannel getChannel() {
        return channel;
    }

    public Guild getGuild() {
        return guild;
    }

    public Message getMessage() {
        return message;
    }

    public Member getMember() {
        return member;
    }

    public String[] getArgs() {
        return args;
    }

    public User getUser() {
        return user;
    }

    public int getCooldownLeft() {
        return cooldown;
    }
}
