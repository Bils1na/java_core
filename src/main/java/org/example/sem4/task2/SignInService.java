package org.example.sem4.task2;

public class SignInService {

    /**
     * Метод проверки логина и пароля
     * @param authentifire
     * @return
     * @throws WrongLoginException
     * @throws WrongPasswordException
     */
    public static boolean checkCredentials(Authentifire authentifire) throws WrongLoginException, WrongPasswordException {
        boolean conf = authentifire.getPassword().equals(authentifire.getConfirmedPassword());
        int loginLength = authentifire.getLogin().length();
        int passwordLength = authentifire.getPassword().length();
        if (loginLength >= 20) {
            throw new WrongLoginException(loginLength);
        } else if (passwordLength < 20 || !conf) {
            throw new WrongPasswordException(passwordLength, conf);
        } else {
            //TODO: проверка логина и пароля на уровне субд
            return true;
        }
    }

}
