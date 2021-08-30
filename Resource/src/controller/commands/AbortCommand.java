package controller.commands;

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
        return "Cancel";
    }
}
