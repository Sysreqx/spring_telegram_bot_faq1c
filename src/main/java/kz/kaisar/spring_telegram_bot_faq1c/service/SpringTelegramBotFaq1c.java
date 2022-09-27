package kz.kaisar.spring_telegram_bot_faq1c.service;

import kz.kaisar.spring_telegram_bot_faq1c.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringTelegramBotFaq1c extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    @Autowired
    public SpringTelegramBotFaq1c(BotConfig botConfig) throws TelegramApiException {
        this.botConfig = botConfig;

        List<BotCommand> listofCommands = new ArrayList<>();
        listofCommands.add(new BotCommand("/start", "Get 1C FAQ"));

        this.execute(new SetMyCommands(listofCommands, new BotCommandScopeDefault(), null));
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();

        if (command.equals("/start")) {
            String message = "1. Как установить программный ключ?\n" +
                    "2. Нами приобретена дополнительная лицензия. На какой компьютер необходимо её установить?" +
                    "3. При инициализации СЛК в момент запуска «1С:Предприятия» выводится окно с текстом «Ошибка связи: Версия сервера Х.Х.Х.Х не соответствует версии клиента Х.Х.Х.Х»" +
                    "4. В момент ввода пинкода в диалоге установки программного ключа выводится сообщение «Указанное значение не является кодом активации программного ключа СЛК»" +
                    "5. Необходимо использовать на одном компьютере конфигурации с разными версиями СЛК. Как это можно сделать?" +
                    "6. Изменение каких технических характеристик компьютера приводит к неработоспособности программного ключа?" +
                    "7. Где физически располагаются программные ключи?" +
                    "8. При инициализации СЛК в момент запуска «1С:Предприятия» выводится окно с сообщением «Ошибка связи:…»." +
                    "9. При использовании английской версии операционной системы, СЛК не инициализируется и выводится сообщение об ошибке: «Ошибка создания защищенной обработки: Защищенный объект ?????_?????? не найден»." +
                    "10. Где можно получить драйверы аппаратных ключей, утилиты, дистрибутивы СЛК?";
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);

            try {
                execute(response);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
