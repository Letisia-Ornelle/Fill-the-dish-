package home.home2;

public class PendentScreen {
    private String screen;
    private String label;

    public PendentScreen() {
        screen = "";
    }

    public String get() {
        String next = screen;
        screen = "";
        return next;
    }

    public void add(String pendentScreen) {
        screen = pendentScreen;
    }

    public Boolean isNull() {
        if(screen.equals("")) {
            return true;
        }
        return false;
    }

    /*Bisogna definire set e get dell'immagine per la schermata result*/

    public void clear() {
        screen = "";
    }


    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

}
