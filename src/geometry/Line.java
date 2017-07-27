package geometry;

import javafx.scene.layout.Pane;

/**
 * Created by baizor on 27.07.17.
 */
public class Line {

    private Point p1, p2;
    private javafx.scene.shape.Line line;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double calcLength() {
        return p1.calcLength(p2);
    }

    public Point getPointOnLine(float percent) {
        Point direction = p2.minus(p1);                 // 1
        direction = direction.normalize();              // 2
        double length = p1.calcLength(p2) * percent;    // 3
        direction = direction.multiply(length);         // 4
        return p1.plus(direction);                      // 5
    }

    public javafx.scene.shape.Line show(Pane root) {
        if (line == null) {
            line = new javafx.scene.shape.Line();
            root.getChildren().add(line);
        }
        line.setStartX(p1.getX());
        line.setStartY(p1.getY());
        line.setEndX(p2.getX());
        line.setEndY(p2.getY());
        return line;
    }

    public void clear(Pane root) {
        root.getChildren().remove(line);
        line = null;
    }

    public Point getStart() {
        return p1;
    }

    public Point getEnd() {
        return p2;
    }
}
