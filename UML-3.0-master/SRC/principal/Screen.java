package principal;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JFrame {

    private JPanel tags;
    private JPanel tagsText;
    private JPanel tagsPhoto;
    private JLabel tituloLabel;
    private JButton cadastrarUsuarioButton;
    private JButton fazerLoginButton;
    private JLabel imagem;
    private ImageIcon icon;

    public Screen() {
        Container c = getContentPane();
        tags = new JPanel();
        tagsText = new JPanel();
        tagsPhoto = new JPanel();
        tags.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tags.setBackground(Color.GRAY);
        tagsPhoto.setBackground(Color.GRAY);

        tituloLabel = new JLabel("MENU");
        tagsText.add(tituloLabel, BorderLayout.CENTER);

        icon = new ImageIcon(getClass().getResource("IMAGEM.png"));
        imagem = new JLabel(icon);
        icon.setImage(icon.getImage().getScaledInstance(220, 220, 100));
        tagsPhoto.add(imagem, BorderLayout.CENTER);

        cadastrarUsuarioButton = new JButton("Cadastrar Usuario");
        tags.add(cadastrarUsuarioButton, BorderLayout.CENTER);

        fazerLoginButton = new JButton("Fazer Login");
        tags.add(fazerLoginButton, BorderLayout.CENTER);

        c.add(tags, BorderLayout.SOUTH);
        c.add(tagsText, BorderLayout.NORTH);
        c.add(tagsPhoto, BorderLayout.CENTER);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // TESTE!!!

        cadastrarUsuarioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                TelaCadastro tela = new TelaCadastro();

                tela.setVisible(true);

                setVisible(false);

            }
        });

        // TESTE!!

        fazerLoginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                TelaLogin screen = new TelaLogin();

                screen.setVisible(true);

                setVisible(false);
            }
        });

    }

}