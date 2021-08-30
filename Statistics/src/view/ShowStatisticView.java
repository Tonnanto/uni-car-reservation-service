package view;

import controller.Command;
import controller.Config;
import controller.StatisticsService;
import controller.commands.ContinueStatisticsCommand;
import controller.commands.FinishStatisticsCommand;
import model.BookingFile;
import model.BookingStatisticVisitor;

import java.util.ArrayList;
import java.util.List;

public class ShowStatisticView extends SelectionView {

    final StatisticsService statisticsService;

    public ShowStatisticView(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new ContinueStatisticsCommand(statisticsService));
        commands.add(new FinishStatisticsCommand(statisticsService));
        return commands;
    }

    @Override
    protected String getMessage() {
        BookingStatisticVisitor statistic = statisticsService.getLastStatistic();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(Config.resourceBundle.getString("statistics.view.ShowStatisticView.Message1") + " %s " + Config.resourceBundle.getString("statistics.view.ShowStatisticView.Message2") + " %s:", statistic.getLanguage(), statistic.getPaymentType())).append("\n");

        for (BookingFile bookingFile : statistic.getBookingFiles()) {
            sb.append("\n").append(bookingFile.getName()).append(" -> ").append(bookingFile.getBooking().getPayment().getCurrencyAmount().to(Config.currency));
        }

        sb.append(String.format("\n\n%s " + Config.resourceBundle.getString("statistics.view.ShowStatisticView.Message3") + " %s.", statistic.getBookingsCount(), statistic.getBookingsValue(Config.currency))).append("\n");

        return sb.toString();
    }
}
