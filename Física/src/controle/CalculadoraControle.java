package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.Principal;

public class CalculadoraControle implements ActionListener {
    private Principal view;

    public CalculadoraControle(Principal view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.calcular();
    }
}
