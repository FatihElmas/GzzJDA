package com.colaria.colariumjda.command;


public interface Command{
    /**
     *
     * @param e Command Parameters
     * Executes when the command execute.
     */
    public void execute(CommandEvent e);

    /**
     * When User not permission for command, calls this method.
     */
    public void onPermissionError(CommandEvent e);

    /**
     * When in cooldown, executes this method.
     */
    public void onCooldownError(CommandEvent e);
}
