//Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder,
//создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.
package Lesson2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;Gson gson = new Gson();
Gson gson = new GsonBuilder().create();
public class Task2 {
    public static void main(String[]args) throws JSONException{
        String jsonString = "[{'фамилия':'Иванов','оценка':'5','предмет':'Математика'}," +
            "{'фамилия':'Петрова','оценка':'4','предмет':'Информатика'}," +
                "{'фамилия':'Краснов','оценка':'5','предмет':'Физика'}]";
        JSONArray jsonArray = new JSONArray(jsonString);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            stringBuilder.append('Студент').append(jsonObject.getString('фамилия'))
                    .append('получил').append('по предмету').append(jsonObject.getString('предмет')).append('.n');
        }
        File outputFile = new File("output.txt");
        File logFile = new File("log.txt");
        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.write(stringBuilder.toString());
            writer.close();
        }catch (FileNotFoudException e) {
            FileWriter logWriter = new FileWriter(logFile, true);
            logWriter.write("Ошибка: файл не найден.n");
            logWriter.close();
        }catch (IOException e) {
            FileWriter logWriter - new FileWriter(logFile, true);
            logWriter.write("ошибка:"+ e.getMessage()+"n");
            logWriter.close();
    }
    }
}
