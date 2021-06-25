package controller.commands;

import controller.ResourceService;

public class SelectCarCommand extends ResourceServiceCommand {

    public SelectCarCommand(ResourceService receiver) {
        super(receiver);
    }

    @Override
    public void execute(int i) {
        receiver.selectCar(receiver.getAvailableCars().get(i - 1));
    }
}
