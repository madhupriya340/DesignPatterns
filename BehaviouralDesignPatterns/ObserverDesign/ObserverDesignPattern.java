package BehaviouralDesignPatterns.ObserverDesign;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String weather);
}
interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String weather);
}
class WeatherStation implements Subject{
    List<Observer> observers= new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(String weather){
        for(Observer obs: observers){
            obs.update(weather);
        }
    }
    public void setWeather(String newWeather) {
            notifyObservers(newWeather);
        }
    }
    class PhoneDisplay implements Observer{
        String weather;
        public void update(String weather){
            this.weather=weather;
            display();
        }
        public void display(){
            System.out.println("Phone Display weather updated "+weather);
        }
    }


public class ObserverDesignPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation= new WeatherStation();
        Observer tvDisplay= new PhoneDisplay ();
        weatherStation.addObserver(tvDisplay);
        weatherStation.setWeather("sunny");
    }
}
