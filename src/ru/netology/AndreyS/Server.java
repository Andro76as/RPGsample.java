package ru.netology.AndreyS;

/**
 * Pattern singleton
 * 1 Приватный конструктор
 * 2 Публичный статический метод getInstance который возвращает экземпляр класа всегда один и тот-же
 */
public class Server {
    private static Server instance;
    private Server() {
    }

    public static Server getInstance() {
        if (instance == null)
            instance = new Server();
        return instance;
    }
}
