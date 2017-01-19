package box.discord.command;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

import java.util.Set;

public class CommandListener implements IListener<MessageReceivedEvent> {
    
    private Set<Command> commands;
    
    public CommandListener(Set<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        
        for (Command command : commands) {
            if (command.isCommand(event))
                command.performCommand(event);
        }
    }
}
