package org.example.sem4.task2;

public class Authentifire {

    public Authentifire(String login, String password, String confirmedPassword) {
        this.login = login;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    /**
     * Имя пользователя
     */
    private final String login;

    /**
     * Пароль
     */
    private final String password;

    /**
     * Подтверждение пароля
     */
    private final String confirmedPassword;


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

}
