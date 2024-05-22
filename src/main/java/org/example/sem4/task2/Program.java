package org.example.sem4.task2;

public class Program {

    public static void main(String[] args) {
        // Реквизиты для входа
        Authentifire[] authentifires = {
                new Authentifire("ivan", "qwe123123123123123123", "qwe123123123123123123"), // correct
                new Authentifire("qwe123134f24j5l4j5oiu3232fd23234", "", ""), // wrong login length
                new Authentifire("ivan", "qwe123123123123123123", "qwe1231231231231231234"), // confirm mismatch
                new Authentifire("ivan", "qwe123", "qwe123"), // wrong password length
                new Authentifire("ivan", "qwe123", "11") // worng password length and confirm mismatch
        };


        // Проверка реквизитов
        for (Authentifire credential : authentifires) {
            try {
                System.out.println(SignInService.checkCredentials(credential));
            } catch (WrongLoginException e) {
                e.printStackTrace();
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
            }
        }



    }

}
