package assignment2018;

import javax.swing.*;

public class MyImageIcon extends ImageIcon {
    @Override
    public boolean equals(Object otherImageIcon) {
        MyImageIcon otherMyImageIcon = (MyImageIcon) otherImageIcon;
        if (otherImageIcon == null){
            return false;
        }
        return otherMyImageIcon.getImage() == this.getImage();
    }
}
