package controller.commands;

import controller.ResourceService;
import view.AddCarDecoratorView;

public class SelectActionCommand extends ResourceServiceCommand {

    public SelectActionCommand(ResourceService receiver) {
        super(receiver);
    }

    @Override
    public void execute(int i) {
        // TODO: execute the selected action

        switch (i) {
            case 1:
                new AddCarDecoratorView(receiver).display();
                break;
            case 2:
                return;
            case 3:
                receiver.removeSelection();
        }
    }
}
