package com.example.adrie.organizer;

import android.app.Application;


import java.util.ArrayList;


/**
 * Created by adrie on 05/12/2016.
 */

public class TimetableInformation extends Application {
    public ArrayList<Class> listClassesMonday;
    public ArrayList<Class> listClassesTuesday;
    public ArrayList<Class> listClassesWednesday;
    public ArrayList<Class> listClassesThursday;
    public ArrayList<Class> listClassesFriday;
    public ArrayList<String> classes;


    public TimetableInformation() {
        listClassesMonday = new ArrayList<>();
        listClassesTuesday = new ArrayList<>();
        listClassesWednesday = new ArrayList<>();
        listClassesThursday = new ArrayList<>();
        listClassesFriday = new ArrayList<>();
        classes = new ArrayList<String>();
        fillClassesArray();
    }



    // TODO: quando add uma classe verificar se existe alguma na mesma hora
    public boolean addClass(Class c) {
        if (c.getWeekDay() == "Monday") {
            if (verifyTime(c,listClassesMonday) == true) {
                listClassesMonday.add(c);
            } else {
                return false;
            }

        } else if (c.getWeekDay() == "Tuesday") {
            if (verifyTime(c,listClassesTuesday) == true) {
                listClassesTuesday.add(c);
            } else {
                return false;
            }

        } else if (c.getWeekDay() == "Wednesday") {
            if (verifyTime(c,listClassesWednesday) == true) {
                listClassesWednesday.add(c);
            } else {
                return false;
            }

        } else if (c.getWeekDay() == "Thursday") {
            if (verifyTime(c,listClassesThursday) == true) {
                listClassesThursday.add(c);
            } else {
                return false;
            }

        } else if (c.getWeekDay() == "Friday") {
            if (verifyTime(c,listClassesFriday) == true) {
                listClassesMonday.add(c);
            } else {
                return false;
            }

        }
        return false;
    }

    public boolean verifyTime(Class c, ArrayList<Class> classArrayList) {
        for (int i = 0; i < classArrayList.size(); i++) {
            if (c.getHour() == classArrayList.get(i).getHour()) {
                if (c.getMmin() == classArrayList.get(i).getMmin()) {
                    return false;
                }
            }
        }
        return true;
    }


    public void fillClassesArray() {
        classes.add("Análise Matemática I");
        classes.add("Álgebra Linear");
        classes.add("Introdução à Programação");
        classes.add("Sistemas Digitais");
        classes.add("Tecnologias Web EI");
        classes.add("Gestão");
        classes.add("Análise Matemática II");
        classes.add("Fundamentos de Computação Gráfica");
        classes.add("Métodos Estatíticos");
        classes.add("Tecnologias e Arquitecturas de Computadores");
        classes.add("Programação");
        classes.add("Electrónica");
        classes.add("Programação Orientada a Objectos");
        classes.add("Introdução às Redes de Comunicação");
        classes.add("Sistemas Operativos");
        classes.add("Introdução à Inteligência Artificial");
        classes.add("Base de Dados");
        classes.add("Investigação Operacional");
        classes.add("Sistemas Operativos II");
        classes.add("Empreendedorismo e Inovação");
        classes.add("Serviços de Rede I");
        classes.add("Cablagem Estruturada");
        classes.add("Encaminhamento de Dados");
        classes.add("Segurança");
        classes.add("Tecnologias de Ligação");
        classes.add("Serviços de Rede");
        classes.add("Disponibilidade e Desempenho");
        classes.add("Gestão de redes");
        classes.add("Programação Web");
        classes.add("Ética e Deontologia");
        classes.add("Interacção Pessoa-Máquina");
        classes.add("Programação Avançada");
        classes.add("Modelação e Design");
        classes.add("Conhecimento e Raciocínio");
        classes.add("Estruturas de Dados");
        classes.add("Programação Distribuída");
        classes.add("Arquitecturas Móveis");
        classes.add("Gestão de Projecto de Sofware");
        classes.add("Arquitectura e Administração de Bases de Dados");
        classes.add("Integração de Dados");
        classes.add("Sistemas de Informação I");
        classes.add("Inteligência Computacional");
        classes.add("Sistemas de Informação II");
        classes.add("Metodologias de Optimização e Apoio à Decisão");
        classes.add("Estratégia Organizacional");
    }
}