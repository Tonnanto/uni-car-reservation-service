package controller.commands;

import controller.StatisticsService;

public class FinishStatisticsCommand extends StatisticsServiceCommand {

    public FinishStatisticsCommand(StatisticsService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.finishShowingStatistics();
    }

    @Override
    public String getDescription() {
        return "Done";
    }
}
