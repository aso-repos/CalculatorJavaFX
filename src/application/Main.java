package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, 340, 500, Color.GREY);

        Image icon = new Image(getClass().getResourceAsStream("/aso_logo.png"));
        stage.getIcons().add(icon);
        stage.setTitle("ASO Calculator");
        stage.setResizable(false);

        Text bodyText = new Text();
        bodyText.setText("Calculator Body");
        bodyText.setY(230);
        bodyText.setX(60);
        bodyText.setFont(Font.font("Roboto", 30));
        bodyText.setFill(Color.WHITE);

        Line line = new Line();
        line.setStartX(63);
        line.setStartY(190);
        line.setEndX(267);
        line.setEndY(190);
        line.setStrokeWidth(2);
        line.setStroke(Color.WHITE);
        Line lowerLine = new Line();
        lowerLine.setStartX(63);
        lowerLine.setStartY(250);
        lowerLine.setEndX(267);
        lowerLine.setEndY(250);
        lowerLine.setStrokeWidth(2);
        lowerLine.setStroke(Color.WHITE);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(53);
        rectangle.setY(180);
        rectangle.setWidth(225);
        rectangle.setHeight(80);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.ORANGE);
        rectangle.setStrokeWidth(2);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                170.0,300.0,
                100.0,400.0,
                240.0,400.0
        );
        triangle.setFill(Color.ORANGE);
        triangle.setStroke(Color.RED);
        triangle.setStrokeWidth(2);

        Circle circle = new Circle();
        circle.setCenterX(170);
        circle.setCenterY(370);
        circle.setRadius(90);
        circle.setStrokeWidth(2);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.WHITE);

        Image calc = new Image(getClass().getResourceAsStream("/Calculator.png"));
        ImageView smallImage = new ImageView(calc);
        smallImage.setX(115);
        smallImage.setY(10);
        smallImage.setFitWidth(100);
        smallImage.setPreserveRatio(true);

        root.getChildren().add(bodyText);
        root.getChildren().add(line);
        root.getChildren().add(lowerLine);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(smallImage);
        stage.setScene(scene);
        stage.show();
    }
}