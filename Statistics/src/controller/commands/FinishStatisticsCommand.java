package controller.commands;

import controller.Config;
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
        return Config.resourceBundle.getString("statistics.commands.FinishStatisticsCommand.Description");
    }
}
