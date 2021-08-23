package controller.commands;

import controller.StatisticsService;
import model.PaymentType;
import view.Language;

public class ShowStatisticCommand extends StatisticsServiceCommand {

    final Language language;
    final PaymentType paymentType;

    public ShowStatisticCommand(StatisticsService receiver, PaymentType paymentType, Language language) {
        super(receiver);
        this.paymentType = paymentType;
        this.language = language;
    }

    @Override
    public void execute() {
        receiver.showStatistic(paymentType, language);
    }

    @Override
    public String getDescription() {
        return String.format("%s Bookings paid by %s", language, paymentType);
    }
}
