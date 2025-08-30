package Memento_Pattern;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        MementoHistory history = new MementoHistory();
        editor.write("Hello world");
        history.Save(editor);
        System.out.println(editor.ReadContent());
        editor.write("Hello everyone");
        history.Save(editor);
        System.out.println(editor.ReadContent());
        history.Undo(editor);
        System.out.println(editor.ReadContent());
        history.Redo(editor);

        System.out.println(editor.ReadContent());



    }

}
