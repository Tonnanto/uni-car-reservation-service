package controller.commands;

import controller.StatisticsService;

public class ContinueStatisticsCommand extends StatisticsServiceCommand {

    public ContinueStatisticsCommand(StatisticsService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        // by doing nothing to user will be prompted to select another statistic automatically.
    }

    @Override
    public String getDescription() {
        return "Show another statistic";
    }
}
