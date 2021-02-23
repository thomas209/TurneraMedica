package app.ui;

public class ClasePrincipal {

    private PanelManager manager;
    public static void main(String[] args){
        
        ClasePrincipal principal = new ClasePrincipal();
        principal.iniciarManager();
		principal.showFrame();

    }

    public void iniciarManager() {
        manager = new PanelManager();
        manager.armarManager();
        manager.mostrarPantallaPrincipal();   
    }

    public void showFrame() {
		manager.showFrame();
	}

    
}