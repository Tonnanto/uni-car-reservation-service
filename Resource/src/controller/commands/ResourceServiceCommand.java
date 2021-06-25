package controller.commands;

import controller.Command;
import controller.ResourceService;

public abstract class ResourceServiceCommand implements Command {

    protected ResourceService receiver;

    public ResourceServiceCommand(ResourceService receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(int i) {
        System.out.println("Warning: The default implementation of this command has been executed.");
    }

    @Override
    public void execute(String s) {
        System.out.println("Warning: The default implementation of this command has been executed.");
    }
}
