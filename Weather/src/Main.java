import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;



import java.io.*;
import java.net.URL;
/*
Наступила осень и в нашем городе похолодало.
Вы находитесь в аэропорту Иркутска и решаете, куда можно полететь.
Используйте сервис OpenWeatherMap, чтобы выбрать город с наиболее тёплой погодой.
Вам необходимо поиском по OpenWeatherMap собрать ID как минимум 10 городов.
Например, для Шелехова это 2016764.
Ваша программа должна вывести города и температуру в них в порядке убывания температуры.
 список городов считать из файла или запросить у пользователя
В качестве ответа приложите исходный год класса(-ов) и текстовый файл с примером работы программы.
 */

class City {
    String name;
    mainInfo main;
}

class mainInfo{
    double temp;
}

class ComparatorTemp implements Comparator<City>{
    @Override
    public int compare(City c1, City c2){
            return Double.compare(c1.main.temp, c2.main.temp);
        }
}

public class Main {
public static City getTempAndNameById(String id) {
Gson gson = new Gson();
String API_URL = "https://api.openweathermap.org/data/2.5/weather?id="+id+"&appid=f12f348483ae8c586043f670f11faa8d&units=metric";
City city = new City();
try {
URL url = new URL(API_URL);
InputStream stream = (InputStream) url.getContent();
// передаём сетевой поток специальному считывателю
InputStreamReader reader = new InputStreamReader(stream);
city = gson.fromJson(reader, City.class); // создать нужные классы
        } catch (IOException e) {
System.out.println(e.getMessage()); // в случае исключения выдаём ошибку на экран
        }
    return city; // вернуть значение температуры из объекта weather
    }

    public static void main(String[] args) throws IOException {
    File file = new File("City.txt");
    File answer = new File("Answer.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    ArrayList<City> citys = new ArrayList<City>();
    String line;

    while ((line = br.readLine())!=null){
        City city = new City();
        city = getTempAndNameById(line);
        System.out.println(city.name +"\n"+ city.main.temp);
        citys.add(city);
    }

    Collections.sort(citys, new ComparatorTemp());


    Collections.reverse(citys);

    PrintWriter printWriter = new PrintWriter(answer);

    for (City c : citys){
        printWriter.println(c.name+"\t"+c.main.temp);
    }

    br.close();
    printWriter.close();
}
}