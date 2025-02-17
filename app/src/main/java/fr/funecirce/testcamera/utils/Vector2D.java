package fr.funecirce.testcamera.utils;


public class Vector2D {

    public double x;
    public double y;
    private double r;
    private double angle;

    public Vector2D(double x, double y, double angleInRads) {
        this.x = x;
        this.y = y;
        this.r = 1;
        this.angle = checkAngle(angleInRads);
        
    }

    public Vector2D(double x, double y, int angleInDegrees) {
        this.x = x;
        this.y = y;
        this.r = 1;
        this.angle = checkAngle(Math.toRadians(angleInDegrees));
        
    }

    private static double checkAngle(double a) {
            if (a >= 2*Math.PI) {
                return a-2*Math.PI;
            } else if (a < 0){
                return a+2*Math.PI;
            } else {
                return a;
            }
        }

    
    public void setMagnitude(int magnitude) {
            r = magnitude;
        }
    
    public void rotate(double angleInRads) {
            angle = checkAngle(angle+angleInRads);
        }
    
    public void rotate(int angleInDegrees) {
            angle = checkAngle(angle+Math.toRadians(angleInDegrees));
        }
    
    public float getDx() {
        if (angle == Math.PI/2 || angle == 3*Math.PI/2) return 0;
            return (float) (r*Math.cos(angle));
    }
    
    public float getDy() {
            if (angle == Math.PI) return 0;
            return (float) (r*Math.sin(angle));
        }
    
    public void translate() {
        x += getDx();
        y += -getDy();
    }
    
    public void translate(float dx, float dy) {
        x+=dx;
        y+=dy;
    }

    public double getAngle() {
        return angle;
    }
    
    public static Vector2D add(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x+v2.x, v1.y+v2.y, checkAngle(v1.angle+v2.getAngle()));
    }


}
