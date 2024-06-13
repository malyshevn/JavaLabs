// Малышев Никита Евгеньевич
// группа ПРИ-О-21, вариант 5
// Работа №4, Задание 1-2. Создание программ с графическим интерфейсом.
/*
Создать интерфейс по изображению, используя разные виды компоновок
К созданному интерфейсу добавить интерактивность, создав как минимум 3 различных слушателя, например, при нажатии кнопки выводить текст в текстовое поле, при наведении курсора мыши
выводить соответствующее сообщение, при изменении ползунка типа JSlider выводить его значение, при
нажатии клавиши Enter после набора текста перемещать его куда-нибудь и т.д.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    public static void main(String[] args) {
        // Создаем основное окно
        JFrame frame = new JFrame("Вариант 5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Создаем текстовое поле
        JTextField textField = new JTextField();

        // Панель для текстового поля (сверху)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(textField, BorderLayout.CENTER);

        // Создаем панель для кнопок в центре
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 3));
        JButton button1 = new JButton("Кнопка 1");
        JButton menuButton = new JButton("Меню");
        JButton button2 = new JButton("Кнопка 2");
        centerPanel.add(button1);
        centerPanel.add(menuButton);
        centerPanel.add(button2);

        // Создаем панель для кнопок телефона (внизу)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 3));
        String[] buttonLabels = {
            "1", "2 ABC", "3 DEF",
            "4 GHI", "5 JKL", "6 MNO",
            "7 PQRS", "8 TUV", "9 WXYZ",
            "*", "0", "#"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(e -> textField.setText(label));
            bottomPanel.add(button);
        }

        // Добавляем панели в основное окно
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Слушатель для кнопки 1
        button1.addActionListener(e -> textField.setText("Нажата кнопка 1"));

        // Слушатель для кнопки 2
        button2.addActionListener(e -> textField.setText("Нажата кнопка 2"));

        // Слушатель для меню кнопки
        menuButton.addActionListener(e -> textField.setText("Нажато меню"));

        // Слушатель для наведения курсора на кнопки
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textField.setText("Наведение на кнопку: " + ((JButton)e.getSource()).getText());
            }
        };
        button1.addMouseListener(mouseListener);
        menuButton.addMouseListener(mouseListener);
        button2.addMouseListener(mouseListener);
        for (Component component : bottomPanel.getComponents()) {
            if (component instanceof JButton) {
                component.addMouseListener(mouseListener);
            }
        }

        // Делаем окно видимым
        frame.setVisible(true);
    }
}
