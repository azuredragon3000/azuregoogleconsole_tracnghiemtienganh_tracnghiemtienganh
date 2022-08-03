package com.myapp.tracnghiemtienganh;

public class PassFailed {
    int level;
    boolean pass;
    int index;

    public PassFailed(int level, boolean pass, int index) {
        this.level = level;
        this.pass = pass;
        this.index = index;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean getPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }
}
