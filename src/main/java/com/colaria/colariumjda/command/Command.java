package com.colaria.colariumjda.command;


public interface Command {
    public void execute(CommandEvent e);

    /**
     * When User not permission for command, calls this method.
     */
    public void onPermissionError(CommandEvent e);
}
