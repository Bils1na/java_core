package org.example.sem2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rnd = new Random();
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '*';
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int currentX;
    private static int currentY;
    private static int botX;
    private static int botY;
    private static char[][] field;


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(currentX, currentY, DOT_HUMAN, "Вы победили")) {
                    break;
                }
                aiTurn();
                printField();
                if (checkState(botX, botY, DOT_AI, "Победил компьютер")) {
                    break;
                }
            }
            System.out.println("Желаете сыграть еще раз? (y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     *  Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeY; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите мне координаты хода X и Y\n(от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
        currentX = x;
        currentY = y;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат поля
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    static void aiTurn() {
        char temp;

        do {
            botX = 0;
            botY = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    temp = field[i][j];
                    if (!(field[i][j] == DOT_AI)) {
                        field[i][j] = DOT_HUMAN;
                    }
                    if (checkWin(i, j, DOT_HUMAN, WIN_COUNT)) {
                        botX = i;
                        botY = j;
                        System.out.println("beep");
                        field[i][j] = temp;
                    } else {
                        if (botX == 0 && botY == 0) {
                            botX = rnd.nextInt(fieldSizeX);
                            botY = rnd.nextInt(fieldSizeY);
                            System.out.println("zero");
                            System.out.println(botX + " " + botY);
                        }
                        field[i][j] = temp;
                    }
                }
            }

        }
        while (!isCellEmpty(botX, botY));
        field[botX][botY] = DOT_AI;
        botX = 0;
        botY = 0;
    }

    /**
     * проверка на ничью
     * @return
     */
    static boolean checkDraw() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i, j)) return false;
            }
        }
        return true;
    }

    /**
     * Метод проверки победы
     * @param dot фишка игрока
     * @return
     */
    static boolean checkWin(int row, int col, char dot, int win) {
        if (checkRow(row, dot, win) || checkColumn(col, dot, win) ||
                checkDiagonals(row, col, dot, win)) {
          return true;
        }
        return false;
    }

    /**
     * Проверяет строку на победу
     * @param row
     * @param dot
     * @param win
     * @return
     */
    private static boolean checkRow(int row, char dot, int win) {
        boolean isWin = true;
        int count = 0;

        for (int i = 0; i < field[row].length; i++) {
            if (!(dot == field[row][i])) {
                isWin = false;
                count = 0;
            } else count++;

            if (count == win) {
                isWin = true;
                return isWin;
            }
        }
        return isWin;
    }

    /**
     * Проверяет столбец на победу
     * @param col
     * @param dot
     * @param win
     * @return
     */
    private static boolean checkColumn(int col, char dot, int win) {
        boolean isWin = true;
        int count = 0;

        for (int i = 0; i < field.length; i++) {
            if (!(dot == field[i][col])) {
                isWin = false;
                count = 0;
            } else count++;

            if (count == win) {
                isWin = true;
                return isWin;
            }
        }
        return isWin;
    }

    /**
     * Проверяет диагонали на победу
     * @param row
     * @param col
     * @param dot
     * @param win
     * @return
     */
    private static boolean checkDiagonals(int row, int col, char dot, int win) {
        boolean isWin = false;
        int count = 0;

        for (int i = 0; i < field.length; i++) {
            if (row == col) {
                if (!(dot == field[i][i])) {
                    isWin = false;
                    count = 0;
                } else count++;
            } else {
                if (!(dot == field[i][field.length-1-i])) {
                    isWin = false;
                    count = 0;
                } else count++;
            }

            if (count == win) {
                isWin = true;
                return isWin;
            }
        }
        return isWin;
    }

    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return
     */
    static boolean checkState(int row, int col, char dot, String s) {
        if (checkWin(row, col, dot, WIN_COUNT)) {
            System.out.println(s);
            return true;
        }
        else if (checkDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }
}

