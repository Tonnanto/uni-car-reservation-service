package controller.commands;

import controller.Command;
import controller.ResourceService;

public abstract class ResourceServiceCommand implements Command {

    protected ResourceService receiver;

    public ResourceServiceCommand(ResourceService receiver) {
        this.receiver = receiver;
    }
}
