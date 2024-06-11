package org.jhidalgo.pooabstractsclasses.form;

import org.jhidalgo.pooabstractsclasses.form.elements.*;
import org.jhidalgo.pooabstractsclasses.form.elements.select.OptionC;
import org.jhidalgo.pooabstractsclasses.form.validator.*;

import java.util.Arrays;
import java.util.List;

public class ExampleForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidator(new ValidatorRequired());

        InputForm password = new InputForm("clave", "password");
        password.addValidator(new ValidatorRequired())
                .addValidator(new LongValidator(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidator(new ValidatorRequired())
                .addValidator(new EmailValidator());

        InputForm age = new InputForm("edad", "number");
        age.addValidator(new ValidatorNumber());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidator(new NonNull());
        lenguaje.addOptionC(new OptionC("1", "Java"))
        .addOptionC(new OptionC("2", "Python"))
        .addOptionC(new OptionC("3", "JavaScript"))
        .addOptionC(new OptionC("4", "TypeScript").setSelected())
        .addOptionC(new OptionC("5", "PHP"));

        ElementForm salute = new ElementForm("saludo") {
            @Override
            public String paintHtml() {
                return "<input disabled name'" + this.name + "' value='"+ this.value + "'>";
            }
        };

        salute.setValue("Este campo esta deshabilitado");
        username.setValue("john.doe");
        password.setValue("123455");
        email.setValue("jonh.doe@gmail.com");
        age.setValue("30");
        experiencia.setValue("...mas de 10 anios de experiencia...");

        List<ElementForm> elements = Arrays.asList(username, password,
                email, age, experiencia, lenguaje, salute);

        elements.forEach(e -> {
            System.out.println(e.paintHtml());
            System.out.println("<br>");
        });

        elements.forEach(e -> {
            if(!e.isValid()){
                e.getErrors().forEach(System.out::println);
            }
        });

    }
}
