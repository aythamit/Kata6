
package Vista;


import Controlador.Attribute;
import Modelo.Histogram;
import java.util.List;


public class HistogramBuilder<T> {
    
    private final List<T> items;

    public HistogramBuilder(List<T> items) {
        this.items = items;
    }
    
    
    public <A> Histogram<A> build (Attribute<T,A> attribute){
        
        Histogram<A> histo = new Histogram<>();
        for (T it : items) {
            A value = attribute.get(it);
            histo.increment(value);
        }
        return histo;
    }
 
        
    }
    

