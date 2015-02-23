package magiccard;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController {

    @FXML
    private Label  vinte ,percentuale, game;
    @FXML
    private Button carta1, carta2, carta3, start_continue;
    private String vcarta1;
    private String vcarta2;
    private String vcarta3;
    private int pvinte = 0;
    private int ptotali = 0;

    @FXML
    public void changeTxtButton() {
        start_continue.setText("Gioca");
        carta1.setText( "-------"+ "\n-------"+ "\n-------"+ "\n-------"+ "\n-------");
        carta2.setText( "-------"+ "\n-------"+ "\n-------"+ "\n-------"+ "\n-------");
        carta3.setText("-------"+ "\n-------"+ "\n-------"+ "\n-------"+ "\n-------");
    }

    private void bottoneDisabilitato(boolean b) {
        carta1.setDisable(b);
        carta2.setDisable(b);
        carta3.setDisable(b);
    }

    private int calcolaPercentuale() {
        
        int percentualeVinto = (pvinte * 100) / ptotali;
        return percentualeVinto;
    }

    @FXML
    public void reset() {
        changeTxtButton();
        
        bottoneDisabilitato(false);
        Random random = new Random();
        int r = random.nextInt(3);
        if (r == 0) {
            vcarta1 = "Asso";
            vcarta2 = "Tre";
            vcarta3 = "Re";
        }
        if (r == 1) {
            vcarta1 = "Re";
            vcarta2 = "Asso";
            vcarta3 = "Tre";
        }
        if (r == 2) {
            vcarta1 = "Tre";
            vcarta2 = "Re";
            vcarta3 = "Asso";
        }
    }
    
   
    
    @FXML
    public void carta1() {
        if (vcarta1.equalsIgnoreCase("Asso")) {
            pvinte++;
        
            vinte.setText("Totale vittorie" + String.valueOf(this.pvinte));
            
            //statistiche();
            
            game.setText("Hai vinto!");
        } else {
            
            game.setText( vcarta1 + " -> Hai perso..");
        }
        carta1.setText(vcarta1);
        carta2.setText(vcarta2);
        carta3.setText(vcarta3);
        
        percentuale.setText( calcolaPercentuale() + "%");
        
        bottoneDisabilitato(true);
    }

    @FXML
    public void carta2() {
        if (vcarta2.equalsIgnoreCase("Asso")) {
            pvinte++;
            
            vinte.setText("Totale vittorie: " + String.valueOf(this.pvinte));
            
            game.setText("ASSO ! Hai vinto!");

        } else {
            
            game.setText( vcarta2 + " -> Hai perso..");
        }
        carta1.setText(vcarta1);
        carta2.setText(vcarta2);
        carta3.setText(vcarta3);
        
        percentuale.setText( calcolaPercentuale() + "%");
        
        bottoneDisabilitato(true);
    }

    @FXML
    public void carta3() {
        if (vcarta3.equalsIgnoreCase("Asso")) {
            pvinte++;
            
            vinte.setText("Totale vittorie: " + String.valueOf(this.pvinte));
            
            game.setText("Hai vinto!");
        } else {
           
            game.setText( vcarta3 + " -> Hai perso..");
        }
        carta1.setText(vcarta1);
        carta2.setText(vcarta2);
        carta3.setText(vcarta3);
        
        percentuale.setText(calcolaPercentuale() + "%");
        
        bottoneDisabilitato(true);
    }

}
