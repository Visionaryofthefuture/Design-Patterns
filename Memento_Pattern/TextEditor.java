package Memento_Pattern;

public class TextEditor {
    private String content;
    public void write(String content){
        this.content = content;
    }

    public EditorMemento Save(){
        return new EditorMemento(content);
    }
    //Restore functionality (Memento -> Update the state of current content)
    public void restore(EditorMemento memento){
        content = memento.getContent();
    }

    public String ReadContent (){
        return this.content;
    }
}
