package controller.commands;

public class FinishSelectionCommand extends ResourceServiceCommand {
    @Override
    public void execute() {
        receiver.finishSelection();
    }

    @Override
    public String getDescription() {
        return "Finish Selection";
    }
}

