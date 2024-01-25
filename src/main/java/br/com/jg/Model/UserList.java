package br.com.jg.Model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> usersList;

    public UserList() {
        this.usersList = new ArrayList<>();
    }

    public void cadastrarUsuario(String username, String password, String firstName, String lastName, int age, String email){
        if (!searchUsernameAndEmail(username, email)){
            User newUser = new User(username,password,firstName,lastName,age,email);
            usersList.add(newUser);
        }
    }

    public User loginUsuario(String username, String password){
        if (usersList.isEmpty()){
            System.out.println("Nenhum usuario no sistema!");
            return null;
        }else {
            User searchedUser = usersList.stream().filter(u -> username.equals(u.getUsername()))
                    .findAny().orElse(null);
            if (searchedUser == null) {
                System.out.println("Usuario não encontrado, tente novamente");
                return null;
            }
            if (!searchedUser.getPassword().equals(password)) {
                System.out.println("Senha incorreta, tente novamente");
                return null;
            } else {
                System.out.println("Usuario encontrado, login efetuado com sucesso");
                return searchedUser;
            }
        }
    }

    private boolean searchUsernameAndEmail(String username, String email){
        if (usersList.stream().anyMatch(u -> username.equals(u.getUsername()))){
            System.out.println("Usuario já existe");
            return true;
        } else if (usersList.stream().anyMatch(u -> email.equalsIgnoreCase(u.getEmail()))) {
            System.out.println("Email já cadastrado");
            return true;
        }else {
            return false;
        }
    }
}
