package com.mycompany.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchUser {
    private String surname;
    private String name;
    public String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void compareUsers() throws FileNotFoundException {

        BufferedReader b = null;
        String surname;
        String name;
        String string;
        try {
            b = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = b.readLine()) != null) {
                string = line;
                surname = line.substring(0, (line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                name = line.substring(0, (line.indexOf(' ')));

                if (surname.equals(this.surname) && name.equals(this.name)) {
                    this.answer= string;
                    break;
                }
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
