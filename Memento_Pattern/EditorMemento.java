package Memento_Pattern;
import java.util.*;


public class EditorMemento {
     public final String Content ;

    public EditorMemento(String content){
        this.Content = content;
    }

    public String getContent(){
           return Content;
    }
}

