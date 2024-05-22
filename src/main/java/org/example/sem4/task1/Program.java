package org.example.sem4.task1;

public class Program {

    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        for (int i = 0; i < 10; i++) {
            System.out.printf("\n**** Итерация #%d ****\n", i + 1);
            processArray(arrayUtils);
        }
    }

    static void processArray(ArrayUtils arrayUtils) {
        try {
            System.out.printf("Сумма всех элементов массива: %d\n", arrayUtils.processArray(arrayUtils.generateArray()));
        } catch (MyArrayDataException e) {
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        } catch (MyArraySizeException e) {
            System.out.printf("%s Требовалось 4х4, получили %dx%d\n", e.getMessage(), e.getX(), e.getY());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

