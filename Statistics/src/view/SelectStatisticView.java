package view;

import controller.Command;
import controller.StatisticsService;

import java.util.List;

public class SelectStatisticView extends SelectionView {

    StatisticsService statisticsService;

    public SelectStatisticView(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    protected List<Command> getCommands() {
        return null;
    }

    @Override
    protected String getMessage() {
        return "Select a Statistic";
    }
}
