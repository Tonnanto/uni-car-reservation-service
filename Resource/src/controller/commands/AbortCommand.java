package controller.commands;

import controller.Config;
import controller.ResourceService;

public class AbortCommand extends ResourceServiceCommand{

    public AbortCommand(ResourceService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.abort();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("resource.controller.commands.AbortCommand.Description");
    }
}
