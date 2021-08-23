package view;

import controller.Command;
import controller.StatisticsService;
import controller.commands.ShowStatisticCommand;
import model.PaymentType;

import java.util.ArrayList;
import java.util.List;

public class SelectStatisticView extends SelectionView {

    final StatisticsService statisticsService;

    public SelectStatisticView(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        for (Language language : Language.values()) {
            for (PaymentType paymentType : PaymentType.values()) {
                commands.add(new ShowStatisticCommand(statisticsService, paymentType, language));
            }
        }

        return commands;
    }

    @Override
    protected String getMessage() {
        return "Select a Statistic";
    }
}
