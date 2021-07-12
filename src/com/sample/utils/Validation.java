package com.sample.utils;

import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validation {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean check_input_empty(TextField jfxTextField){
        if(jfxTextField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur liée au formulaire");
            alert.setContentText("Veuillez remplir le formulaire");
            alert.showAndWait();
            jfxTextField.requestFocus();
            return true;
        }else {
            return false;
        }
    }

    public static boolean check_input_textarea(TextArea jfxTextField){
        if(jfxTextField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur liée au formulaire");
            alert.setContentText("Veuillez remplir le formulaire");
            alert.showAndWait();
            jfxTextField.requestFocus();
            return true;
        }else {
            return false;
        }
    }

    public static boolean check_input_size(TextField jfxTextField, int size){
        if(jfxTextField.getText().trim().length() > size){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur liée au formulaire");
            alert.setContentText("Le nombre de caractères maximal pour ce champ est de "+size);
            alert.showAndWait();
            jfxTextField.requestFocus();
            return true;
        }else {
            return false;
        }
    }

    public static boolean check_input_email(TextField jfxTextField){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!jfxTextField.getText().trim().matches(regex)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur liée au formulaire");
            alert.setContentText("L'email est invalide.");
            alert.showAndWait();
            jfxTextField.requestFocus();
            return true;
        }else {
            return false;
        }
    }

//    public static boolean check_input_phone_number(JFXTextField jfxTextField){
//        String phoneNumber = jfxTextField.getText().trim();
//        String regex="((\\(\\d{3}\\)?)|(\\d{3}))([\\s-./]?)(\\d{3})([\\s-./]?)(\\d{4})$";
//        if(!phoneNumber.matches(regex)){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erreur liée au formulaire");
//            alert.setContentText("Numéro de téléphone invalide.");
//            alert.showAndWait();
//            jfxTextField.requestFocus();
//            return true;
//        }else{
//            return false;
//        }
//    }

    public static boolean check_date(DatePicker debut, DatePicker fin){
        if(debut.getValue().isAfter(fin.getValue())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur liée au formulaire");
            alert.setContentText("La date de début doit venir avant la date fin.");
            alert.showAndWait();
            debut.requestFocus();
            return true;
        }else {
            return false;
        }
    }

    public static boolean check_selected(ComboBox jfxComboBox){
        if(jfxComboBox.getSelectionModel().getSelectedIndex() == -1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur liée au formulaire");
            alert.setContentText("Veuillez effectuer un choix.");
            alert.showAndWait();
            jfxComboBox.requestFocus();
            return true;
        }else {
            return false;
        }
    }

    public static LocalDate string_to_date(String text){
        LocalDate date = null;

        if(text !=null && !text.trim().isEmpty()){
            date = LocalDate.parse(text, dateTimeFormatter);
        }

        return date;
    }

    public static String date_to_string(LocalDate localDate){
        String text = null;
        if(localDate!=null){
            text = dateTimeFormatter.format(localDate);
        }
        return text;
    }
}
