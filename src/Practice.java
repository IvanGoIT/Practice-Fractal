import geometry.Line;
import geometry.Point;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by baizor on 13.07.17.
 */
public class Practice extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // инициализируем название и размеры окна
        primaryStage.setTitle("Fractal");
        primaryStage.setWidth(600);
        primaryStage.setHeight(300);
        Pane root = new Pane();

        // построение первой линии
        Line line = new Line(new Point(50, 150), new Point(550, 150));
        Point center = line.getPointOnLine(0.5f);

        // построение линии от начала первой линии до ее центра
        Line lineToCenter = new Line(line.getStart(), center);

        // отрисовка обеих линий
        line.show(root).setStrokeWidth(10);         // задаем ширину линии 10 пикселей
        lineToCenter.show(root).setStrokeWidth(20); // задаем ширину линии 20 пикселей

        // отрисовка окна приложения
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
