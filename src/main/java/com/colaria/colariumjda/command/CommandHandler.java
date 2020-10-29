package com.colaria.colariumjda.command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandHandler extends ListenerAdapter {

    private final List<Command> commands = new ArrayList<>();
    private final HashMap<Command, CommandParams> paramsMap = new HashMap<>();
    private final List<Command> errors = new ArrayList<>();
    private final CommandCooldown cooldown = new CommandCooldown();

    public CommandHandler() {
        Reflections reflections = new Reflections();
        reflections.getSubTypesOf(Command.class).forEach(clazz -> {
            try {
                Command command = clazz.newInstance();
                if (clazz.getAnnotation(CommandParams.class) == null) {
                    errors.add(command);
                    throw new CommandException("Command Parameters not defined! (" + clazz.getName() + ")");
                } else {
                    CommandParams params = clazz.getAnnotation(CommandParams.class);
                    commands.add(command);
                    paramsMap.put(command, params);
                    System.out.println("[ColariumJDA] => Registered " + params.name() + " command. (" + params.status() + ")");
                }
            } catch (Exception e) {
                System.out.println("CommandException -> " + e.getMessage());
            }
        });
        System.out.println("[ColariumJDA] => " + commands.size() + " of command registered successfully.");
    }


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        args = Arrays.copyOfRange(args, 1, args.length);
        for (Command command : commands) {
            CommandParams params = paramsMap.get(command);
            if (!params.status()) continue;
            if (e.getMessage().getContentRaw().startsWith(params.prefix() + params.name()) || Arrays.asList(params.aliases()).contains(e.getMessage().getContentRaw().split(" ")[0].replace(params.prefix() + "", ""))) {

                if (cooldown.isOnCooldown(e.getAuthor())) {
                    CommandEvent event = new CommandEvent(e.getChannel(), e.getMessage(), args, e.getAuthor(), e.getGuild(), e.getMember(), cooldown.getCooldownSeconds(e.getAuthor()));
                    command.onCooldownError(event);
                    return;
                }
                CommandEvent event = new CommandEvent(e.getChannel(), e.getMessage(), args, e.getAuthor(), e.getGuild(), e.getMember(), 0);
                if (params.permissions().length > 0) {
                    if (e.getMember().getPermissions().containsAll(Arrays.asList(params.permissions()))) {
                        command.execute(event);
                        cooldown.putInCooldown(e.getAuthor(), params.cooldown());
                    } else {
                        command.onPermissionError(event);
                    }
                } else {
                    cooldown.putInCooldown(e.getAuthor(), params.cooldown());
                    command.execute(event);
                }
            }
        }
    }
}
