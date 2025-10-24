package ua.opnu;

import java.awt.Point;

public class Point3D extends Point {
    private double z;

    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y) {
        super.x = x;
        super.y = y;
        this.z = 0;
    }

    public void setLocation(int x, int y, int z) {
        super.x = x;
        super.y = y;
        this.z = z;
    }

    public double distance(Point3D p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        double dz = z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    public double getZ() {
        return z;
    }

    public double distanceFromOrigin() {
        double x = getX();
        double y = getY();
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[x=" + x + ", y=" + y + ", z=" + z + "]";
    }
}