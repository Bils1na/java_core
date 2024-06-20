package org.example.jdk_sem3.tasks;

public class Program {
//    Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три перемен-
//    ные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K), методы
//    возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
//    классов для трех переменных класса. Наложить ограничения на параметры типа: T дол-
//    жен реализовать интерфейс Comparable (классы оболочки, String), V должен реализо-
//    вать интерфейс DataInput и расширять класс InputStream, K должен расширять класс
//    Number.


//    Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
//    возможность хранить любые типы данных, иметь методы добавления и удаления элемен-
//    тов.

    public static void main(String[] args) {
//        MyClass<String, DataInputStream, Integer> myClass = new MyClass<>("Text", new DataInputStream(System.in), 9);
//        myClass.nameVarClasses();

//        MyCollection<String> collection = new MyCollection<>();
//        collection.add("Artem");
//        collection.add("Andrey");
//        collection.add("Maslo");
//        collection.add("Mylo");
//        System.out.println(collection.toString());
//        collection.delete(1);
//        System.out.println(collection.toString());


    }

    private static <T extends Number, V extends Number> void sum(T a, V b) {

   }

}
