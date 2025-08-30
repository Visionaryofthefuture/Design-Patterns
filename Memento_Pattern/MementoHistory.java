package Memento_Pattern;
import java.util.Stack;

public class MementoHistory {
    private final Stack<EditorMemento> history = new Stack<>();
    private final Stack<EditorMemento> RedoStack = new Stack<>();
    public void Save(TextEditor editor){
        this.history.push(editor.Save());
    }
    public void Undo(TextEditor editor){
        if(!this.history.empty()){
            this.RedoStack.push(this.history.peek());
            history.pop();
            editor.restore(history.peek());
        }
    }
    public void Redo(TextEditor editor){
        if (!this.RedoStack.empty()){
            history.push(this.RedoStack.peek());
            RedoStack.pop();
            editor.restore(history.peek());
        }
    }
}
