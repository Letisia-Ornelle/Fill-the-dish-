package home.home2;

public class PendentScreen {
    private String screen;

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
        if (screen.equals("")) {
            return true;
        }
        return false;
    }

    public void clear() {
        screen = "";
    }

}
