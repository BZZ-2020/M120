package N2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serial;

public class View extends JFrame {
    @Serial
    private static final long serialVersionUID = 1659560662167244636L;
    private final DefaultListModel<String> model;
    private JList<String> viewComponent;
    private JTextField inputValue;

    public View(DefaultListModel<String> m) {
        super("View-Komponente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = m;
        init();
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Demo zu MVC mit JList");
        Model m = new Model();
        new View(m);
    }

    private void init() {
        viewComponent = new JList<>(model);
        JScrollPane scroller = new JScrollPane(viewComponent);
        this.getContentPane().add(scroller, BorderLayout.CENTER);
        JButton addItem = new JButton("add Item");
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.add(addItem, BorderLayout.EAST);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        addItem.addActionListener(e -> onAddItem());
        inputValue = new JTextField(10);
        inputValue.setVisible(false);
        this.getContentPane().add(inputValue, BorderLayout.NORTH);

        inputValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                onEnter(arg0);
            }
        });
    }

    private void onAddItem() {
        inputValue.setVisible(true);
        pack();
        this.repaint();
        inputValue.requestFocus();
    }

    private void onEnter(KeyEvent event) {
        if (event.getKeyChar() == KeyEvent.VK_ENTER) {
            System.out.println("ENTER");
            inputValue.setVisible(false);
            pack();
            this.repaint();
            viewComponent.requestFocus();
            model.addElement(inputValue.getText());
            inputValue.setText("");
        }
    }
}
