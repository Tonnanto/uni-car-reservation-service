package controller.commands;

import controller.Command;
import controller.StatisticsService;

public abstract class StatisticsServiceCommand implements Command {
    final StatisticsService receiver;

    public StatisticsServiceCommand(StatisticsService receiver) {
        this.receiver = receiver;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
