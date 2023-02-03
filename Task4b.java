package HomeWork.Task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Task4b {
    public static void main(String[] args) throws IOException {
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();
        try {
            FileWriter write = new FileWriter("Test.sql");
            write.append("Иванов Иван Иванович 32 М\n");
            write.append("Иванова Ольна Ивановна 12 Ж\n");
            write.append("Адоров Олег Александрович 42 М\n");
            write.append("Боромонов Илья Олегович 18 М\n");
            write.append("Петренко Клавдия Захаровна 54 Ж\n");
            write.flush();
            write.close();
         }catch (IOException e) {
            e.printStackTrace();
         }
        String text = "";
       
            FileReader fileread = new FileReader("Test.sql");
                 while(fileread.ready()){
                    text += (char)fileread.read();
                }
        System.out.println(text);  
        String [] str = text.split("\n");
        for (int i = 0; i < str.length; i++) {
            String [] tmp = str[i].split(" ");
            surname.add(tmp[0]);
            name.add(tmp[1]);
            patronymic.add(tmp[2]);
            age.add(Integer.parseInt((tmp[3])));
            gender.add(tmp[4].equalsIgnoreCase("Ж")?true:false);
            index.add(i);
        }
        ArrayList<String> tmp = new ArrayList<>(surname);
        Collections.sort(tmp);
        for (int i = 0; i < tmp.size(); i++) {
            int j = surname.indexOf(tmp.get(i));
            index.set(i,j);
        }
            
        for (int i = 0; i <index.size(); i++) {
            System.out.print(surname.get(index.get(i))+" ");
        }

            
        
        
        
    }

}
