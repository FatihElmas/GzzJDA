# GzzJDA
A excellent, basic utility for your cool JDA (Java Discord API) Bots with A++ Code Quality.

## Usage
Utility usages...
### Commands
```java
@CommandParams(
prefix = "gzz!", // Prefix for your Command
aliases = {"ex", "examp"}, // Command Aliases
name = "example", // Command
permissions= {Permission.ADMINISTRATOR, Permission.MANAGE_CHANELL...}, // Permissions for command
status = true, // State for Command same as Active/Deactive. 
cooldown = 10 // Cooldown with seconds format
)
public class ExampleCommand implements Command {

    @Override
    public void execute(CommandEvent e) {
      // code...
    }
  
    public void onPermissionError(CommandEvent e) { // Calling when users privileges not enough to executes command.
      // code...
    }

    public void onCooldownError(CommandEvent e) { // Calling when user uses command but in cooldown.
      // code...
    }

}
```
