package home.home2.Model.Beans;

public class enrollBean {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    public void setUsername(String userName){
        this.username = userName;
    }

    public String getUsername(){
        return username;
    }


    public void setName(String name){
        this.nome = name;
    }

    public String getName(){
        return nome;
    }

    public void setCognome(String Cognome){
        this.cognome = Cognome;
    }
    public String getCognome(){
        return cognome;}

    public void setEmail(String Email){
        this.email = Email;
    }
    public String getEmail(){
        return email;}

    public void setPassword(String pwd){
        this.password = pwd;
    }
    public String getPassword(){
        return password;
    }
}
