package Modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
   
    private final Map<T, Integer> map = new HashMap<T, Integer>();
    
    
    public Integer get(T key){
        return map.get(key);
    }
    
    public Set<T> keySet(){
        return map.keySet();    
    }
    
    public void increment(T key){
           map.put(key , map.containsKey( key ) ? map.get( key ) + 1 : 1 );
    }
    
    public void mostrar(){
        System.out.println("Tamaño: " + map.size());
        for (T key : map.keySet()) {
            System.out.println(key + "  ==>  " + map.get(key));               
        }
    }

    
}
