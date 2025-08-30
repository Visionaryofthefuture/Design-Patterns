package Observer_Pattern;

import java.lang.reflect.Array;
import java.util.ArrayList;
interface Observer{
    void update (float temp);
}

interface Subject{
    void attach(Observer obs);
    void detach(Observer obs);
    void notifyObservers();
}

class Weather implements Subject{
    private float Temperature;
    private ArrayList<Observer> observers;
    public float getTemperature(){
        return Temperature;
    }

    public Weather(){
        observers = new ArrayList<>();
    }

    public void setTemperature(float temp){
        this.Temperature = temp;
        notifyObservers();
    }

    @Override
    public void attach(Observer obs){
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs){
        try{
            observers.remove(obs);
        }
        catch(IndexOutOfBoundsException e1){
            System.out.println(e1.getMessage());
        }

    }
    @Override
    public void notifyObservers(){
        for(Observer obs : observers){
            obs.update(Temperature);
        }
    }
}


class WeatherAppDevice implements Observer{
    public float current_temp  ;
    private String name;
    public WeatherAppDevice(String name){
        this.name = name;
    }
    @Override
    public void update(float temp){
        this.current_temp = temp;
    }
    public void get_temp(){
        System.out.println("Device : " + this.name + " " + current_temp);
    }
}
public class WeatherStationMain {
    public static void main(String[] args){
        Weather weatherstation = new Weather();
        WeatherAppDevice Mobile = new WeatherAppDevice("Mobile");
        WeatherAppDevice laptop = new WeatherAppDevice("laptop");

        weatherstation.attach(Mobile);
        weatherstation.attach(laptop);
        weatherstation.setTemperature(50.0f);
        Mobile.get_temp();
        laptop.get_temp();
        System.out.println(weatherstation.getTemperature());


        weatherstation.setTemperature(40.0f);
        Mobile.get_temp();
        laptop.get_temp();
        System.out.println(weatherstation.getTemperature());

    }
}
