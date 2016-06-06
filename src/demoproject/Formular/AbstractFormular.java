/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lenovo
 */
public class AbstractFormular implements Formular
{
    private Collection<Node> elements;
    
    private int i = 0;
    private int j = 0;

    public AbstractFormular() {
        this.elements = FXCollections.<Node>observableArrayList();
    }
    
    @Override
    public void show(Stage s, String formTitle) {
        GridPane grid = new GridPane();
//        Parent parent = s.getScene().getRoot();
//        parent.getChildrenUnmodifiable().forEach((Node n) -> {
//            if (n instanceof MenuBar) {
//                this.setElement(n);
//            }
//        });
        
        this.elements.forEach((Node n) -> {
            grid.add(n, i, j);
            if (i == 1) {
                i = 0;
                j++;
            }
            i++;
        });
//        grid.getChildren().addAll(this.elements);
        grid.setPadding(new Insets(25, 25, 25, 25));
        s.setTitle(formTitle);
        
       
        
        Scene scene = new Scene(grid, 800, 600);
        scene.getStylesheets().add("css/form.css");
        s.setScene(scene);
        s.show();
    }

    @Override
    public void hide() {
        
    }
    
    public Collection<Node> getElements()
    {
        return elements;
    }
    
    /**
     *
     * @param elements
     */
    public void setElements(Collection<Node> elements) 
    {
        this.elements = elements;
    }
    
    /**
     *
     * @param element
     */
    public void setElement(Node element)
    {
        if (null != element) {
            this.elements.add(element);
        }
    }

   
}
