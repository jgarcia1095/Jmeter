package com.sofka.automatizacion.api;

import Singleton.ClienteSingleton;
import co.com.sofka.test.jmeter.ExecutionJmeter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConsumoRest extends ExecutionJmeter {
    static final String NOMBRE_SCRIPT="REST";
    ClienteSingleton clienteSingleton=ClienteSingleton.getInstance();


    public void consumirRest()throws Exception{

        String[] aux=execJmeter(NOMBRE_SCRIPT,null,null,";");

        for (int i = 0; i < aux.length; i++) {
            System.out.println(aux[i]);
        }
        ArrayList<String> valores = new ArrayList<>();
        valores.add("<ID>(.*?)</ID>");
        valores.add("<FIRSTNAME>(.*?)</FIRSTNAME>");
        valores.add("<LASTNAME>(.*?)</LASTNAME>");
        valores.add("<STREET>(.*?)</STREET>");
        valores.add("<CITY>(.*?)</CITY");

        ArrayList<String> resultado = new ArrayList<>();

        for(int i=0;i<valores.size();i++) {
            Pattern pattern = Pattern.compile(valores.get(i));
            Matcher matcher = pattern.matcher(aux[0]);
            if(matcher.find()) {
                resultado.add(matcher.group(1));
            }
        }

        clienteSingleton.setId(resultado.get(0));
        clienteSingleton.setFirstName(resultado.get(1));
        clienteSingleton.setLastName(resultado.get(2));
        clienteSingleton.setStreet(resultado.get(3));
        clienteSingleton.setCity(resultado.get(4));
       /* System.out.println("ID= "+resultado.get(0));
        System.out.println("Fisrt Name= "+resultado.get(1));
        System.out.println("Last Name= "+resultado.get(2));
        System.out.println("Street= "+resultado.get(3));
        System.out.println("City= "+resultado.get(4));*/

    }

    public static void main(String[] args) {
        ConsumoRest api= new ConsumoRest();
        try {
            api.consumirRest();
        }catch (Exception e){
            System.out.println("Falloooooo");
        }

    }
}

