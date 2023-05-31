package principal;

import negocios.Login;
import dados.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

    public String email;
    public String senha;

    private JPanel field;
    private JPanel fieldText;
    private JPanel fieldButton;

    private JTextField emailUsuario;
    private JTextField senhaUsuario;
    private JLabel tituloLabel, titulo1;
    private JButton loginUsuario; 

    public TelaLogin(){

        field = new JPanel();
        fieldText = new JPanel();
        fieldButton = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(200, 20, 10, 20));
        field.setBackground(Color.GRAY);

        Container c = getContentPane();

        titulo1 = new JLabel("Digite Email e Senha:");
        field.add(titulo1);

        //TEXTFIELD
        tituloLabel = new JLabel("LOGIN");
        fieldText.add(tituloLabel, BorderLayout.CENTER);

        emailUsuario = new JTextField();
        emailUsuario.setColumns(20);
        field.add(emailUsuario, BorderLayout.CENTER);

        senhaUsuario = new JTextField();
        senhaUsuario.setColumns(20);
        field.add(senhaUsuario, BorderLayout.CENTER);

        loginUsuario = new JButton("Login");
        fieldButton.add(loginUsuario, BorderLayout.CENTER); 

        c.add(field, BorderLayout.CENTER);
        c.add(fieldText, BorderLayout.NORTH);
        c.add(fieldButton, BorderLayout.SOUTH);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // EVENTO
        loginUsuario.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                Login login = new Login();
                TelaPrincipal tela = new TelaPrincipal(login);

                email = emailUsuario.getText().trim(); 
                senha = senhaUsuario.getText().trim();
            
                if (email.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(field, "Usuário não encontrado ou senha incorreta.");
                } else {

                    tela.setVisible(true);

                    // Exibir informações do usuário!!!
                    String mensagem = "Usuário:\n" +
                    "Email: " + email;
                    JOptionPane.showMessageDialog(null, mensagem); 


                   Usuario usuarioLogado = login.fazerLogin(email, senha);
                   String test = "O resultado: " + usuarioLogado;
                   JOptionPane.showMessageDialog(null, test);

                   if(usuarioLogado != null){
                        tela.setVisible(true);
                        setVisible(false);
                   } else {
                    JOptionPane.showMessageDialog(field, "Usuário não encontrado ou senha incorreta.");
                   }
                }
                     
            }
        });
    }
}
