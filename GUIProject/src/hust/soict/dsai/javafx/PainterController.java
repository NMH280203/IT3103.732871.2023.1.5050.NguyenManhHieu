package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
// Nguyen Manh Hieu 20215050
public class PainterController {

	private Color currentColor = Color.BLACK;
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup tooltoggle;
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    	
    }
    
    @FXML
    void penPainter(ActionEvent event) {
    	currentColor = Color.BLACK;
    }
    
    @FXML
    void eraserPainter(ActionEvent event) {
    	currentColor = Color.WHITE;
    }



}

