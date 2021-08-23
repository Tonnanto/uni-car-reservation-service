package controller.commands;

import controller.Command;
import controller.ResourceService;

public abstract class ResourceServiceCommand implements Command {

    protected final ResourceService receiver;

    public ResourceServiceCommand(ResourceService receiver) {
        this.receiver = receiver;
    }
}
