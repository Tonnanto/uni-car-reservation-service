package controller.commands;

import controller.Command;
import controller.ResourceService;

public abstract class ResourceServiceCommand implements Command {

    protected ResourceService receiver;

    public void setReceiver(ResourceService receiver) {
        this.receiver = receiver;
    }
}
