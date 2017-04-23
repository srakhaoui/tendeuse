package org.prototype.tendeuse;

public interface Mobile {
    
    Orientation getOrientation();
    void setOrientation(Orientation orientation);
    
    Integer getX();
    void setX(Integer x);
    
    Integer getY();
    void setY(Integer y);
}