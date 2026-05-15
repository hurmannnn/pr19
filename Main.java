import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void bubbleSort(int[] array, boolean count) {//масив з чисел які треаб відсортувати за зростанням або спаданням
        for (int i = 0; i < array.length - 1; i++) {//прохід по елементам масиву
            for (int j = 0; j < array.length - 1 - i; j++) {//порівнання елементів
//зростання
                if (count && array[j] > array[j + 1]) {//якщо лівий елемент більший за правий - вони міняються
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
//спадання
                if (!count && array[j] < array[j + 1]) {//якщо правий елемент більший за лівий - вони міняються
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        System.out.print("Введіть мінімальне значення: ");
        int min = scanner.nextInt();

        System.out.print("Введіть максимальне значення: ");
        int max = scanner.nextInt();

        int choice;
        while (true) {
            try {
                System.out.print("Оберіть спосіб сортування: 1 - за зростанням, 2 - за спаданням: ");
                choice = scanner.nextInt();

                if (choice != 1 && choice != 2) {
                    throw new IllegalArgumentException("Потрібно ввести 1 або 2");
                }//обробка помилки
                break; //якщо все правильно - вихід з циклу

            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Введіть число 1 або 2");
                scanner.nextLine();
            }
        }

        boolean count = (choice == 1);//якщо вибір 1 - це за сортування по зростнню

        int[] array = new int[size];//поржній масив потрібного розміру який введе користувач(мін і макс число)

        for (int i = 0; i < size; i++) {//прохді по кожному елементу
            array[i] = random.nextInt(max - min + 1) + min;//генерування чисел від мін до макс
        }

        System.out.println("Масив до сортування:");
        System.out.println(Arrays.toString(array));

        bubbleSort(array, count);//передвання масиву для сортування

        System.out.println("Масив після сортування:");
        System.out.println(Arrays.toString(array));

    }
}