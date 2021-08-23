package view;

import controller.Command;
import controller.StatisticsService;
import controller.commands.ContinueStatisticsCommand;
import controller.commands.FinishStatisticsCommand;
import model.BookingFile;
import model.BookingStatisticVisitor;
import model.Currency;

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

        sb.append(String.format("All %s Bookings paid with %s:", statistic.getLanguage(), statistic.getPaymentType())).append("\n");

        for (BookingFile bookingFile : statistic.getBookingFiles()) {
            sb.append("\n").append(bookingFile.getName()).append(" -> ").append(bookingFile.getBooking().getPayment().getCurrencyAmount().to(Currency.EURO));
        }

        sb.append(String.format("\n\n%s Bookings made a total of %s.", statistic.getBookingsCount(), statistic.getBookingsValue(Currency.EURO))).append("\n");

        return sb.toString();
    }
}
