package net.uk.interconnect.dependencyinjection;


import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextFieldTreeCellImpl extends TreeCell<String> {

    private TextField textField;
    @Override
    public void startEdit(){
        super.startEdit();
        if(textField == null){
            createTextField();
        }
        setText(null);
        setGraphic(textField);
        textField.selectAll();

    }

    @Override
    public void cancelEdit(){
        super.cancelEdit();
        setText(getString());
        setGraphic(getTreeItem().getGraphic());

    }

    @Override
    public void updateItem(String item, boolean empty){
        super.updateItem(item,empty);
        if(empty){
            setText(null);
            setGraphic(null);
        } else {
            if(isEditing()){
                if(textField!=null){
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(getTreeItem().getGraphic());
            }
        }

    }

    private String getString(){
        return getItem() == null? "":getItem().toString();
    }

    private void createTextField(){
        textField = new TextField(getString());
        textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    commitEdit(textField.getText());
                } else if (event.getCode()==KeyCode.ESCAPE){
                    cancelEdit();
                }
            }
        });
    }

}
