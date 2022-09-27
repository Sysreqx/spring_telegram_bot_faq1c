package kz.kaisar.spring_telegram_bot_faq1c.service;

import kz.kaisar.spring_telegram_bot_faq1c.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringTelegramBotFaq1c extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    private final String FIRST_BTN = "FIRST_BTN";
    private final String SECOND_BTN = "SECOND_BTN";
    private final String THIRD_BTN = "THIRD_BTN";
    private final String FOURTH_BTN = "FOURTH_BTN";
    private final String FIFTH_BTN = "FIFTH_BTN";
    private final String SIXTH_BTN = "SIXTH_BTN";
    private final String SEVENTH_BTN = "SEVENTH_BTN";
    private final String EIGHTH_BTN = "EIGHTH_BTN";
    private final String NINTH_BTN = "NINTH_BTN";
    private final String TENTH_BTN = "TENTH_BTN";

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
        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (command.equals("/start")) {

                // buttons
                try {
                    register(update.getMessage().getChatId());
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

            if (update.hasCallbackQuery()) {
                String callbackData = update.getCallbackQuery().getData();
                long messageId = update.getCallbackQuery().getMessage().getMessageId();
                chatId = update.getCallbackQuery().getMessage().getChatId();

                if (callbackData.equals(FIRST_BTN)) {
                    String text = "You pressed first button";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                } else if (callbackData.equals(SECOND_BTN)) {
                    String text = "You pressed SECOND button";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                } else if (callbackData.equals(THIRD_BTN)) {
                    String text = "You pressed xxxx button";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (callbackData.equals(FOURTH_BTN)) {
                    String text = "You pressed xxxx button";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (callbackData.equals(FIFTH_BTN)) {
                    String text = "You pressed xxxx button";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }

    private void register(long chatId) throws TelegramApiException {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("1. Как установить программный ключ?\n\n" +
                "2. Нами приобретена дополнительная лицензия. На какой компьютер необходимо её установить?\n\n" +
                "3. При инициализации СЛК в момент запуска «1С:Предприятия» выводится окно с текстом «Ошибка связи: Версия сервера Х.Х.Х.Х не соответствует версии клиента Х.Х.Х.Х»\n\n" +
                "4. В момент ввода пинкода в диалоге установки программного ключа выводится сообщение «Указанное значение не является кодом активации программного ключа СЛК»\n\n" +
                "5. Необходимо использовать на одном компьютере конфигурации с разными версиями СЛК. Как это можно сделать?\n\n" +
                "6. Изменение каких технических характеристик компьютера приводит к неработоспособности программного ключа?\n\n" +
                "7. Где физически располагаются программные ключи?\n\n" +
                "8. При инициализации СЛК в момент запуска «1С:Предприятия» выводится окно с сообщением «Ошибка связи:…».\n\n" +
                "9. При использовании английской версии операционной системы, СЛК не инициализируется и выводится сообщение об ошибке: «Ошибка создания защищенной обработки: Защищенный объект ?????_?????? не найден».\n\n" +
                "10. Где можно получить драйверы аппаратных ключей, утилиты, дистрибутивы СЛК?");

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        // First row
        List<InlineKeyboardButton> rowInLine1 = new ArrayList<>();

        var firstButton = new InlineKeyboardButton();
        firstButton.setText("1");
        firstButton.setCallbackData(FIRST_BTN);

        var secondButton = new InlineKeyboardButton();
        secondButton.setText("2");
        secondButton.setCallbackData(SECOND_BTN);

        var thirdButton = new InlineKeyboardButton();
        thirdButton.setText("3");
        thirdButton.setCallbackData(THIRD_BTN);

        var forthButton = new InlineKeyboardButton();
        forthButton.setText("4");
        forthButton.setCallbackData(FOURTH_BTN);

        var fifthButton = new InlineKeyboardButton();
        fifthButton.setText("5");
        fifthButton.setCallbackData(FIFTH_BTN);

        rowInLine1.add(firstButton);
        rowInLine1.add(secondButton);
        rowInLine1.add(thirdButton);
        rowInLine1.add(forthButton);
        rowInLine1.add(fifthButton);

        // Second row
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        var sixthButton = new InlineKeyboardButton();
        sixthButton.setText("6");
        sixthButton.setCallbackData(SIXTH_BTN);

        var seventhButton = new InlineKeyboardButton();
        seventhButton.setText("7");
        seventhButton.setCallbackData(SEVENTH_BTN);

        var eighthButton = new InlineKeyboardButton();
        eighthButton.setText("8");
        eighthButton.setCallbackData(EIGHTH_BTN);

        var ninthButton = new InlineKeyboardButton();
        ninthButton.setText("9");
        ninthButton.setCallbackData(NINTH_BTN);

        var tenthButton = new InlineKeyboardButton();
        tenthButton.setText("10");
        tenthButton.setCallbackData(TENTH_BTN);

        rowInLine2.add(sixthButton);
        rowInLine2.add(seventhButton);
        rowInLine2.add(eighthButton);
        rowInLine2.add(ninthButton);
        rowInLine2.add(tenthButton);

        // Add rows to array
        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);

        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        execute(message);

    }

}
