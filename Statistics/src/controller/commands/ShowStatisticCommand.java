package controller.commands;

import controller.Config;
import controller.StatisticsService;
import model.PaymentType;
import model.Language;

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
        return String.format("%s" + Config.resourceBundle.getString("statistics.commands.ShowStatisticsCommand.Description") + " %s", language, paymentType);
    }
}
