package com.example.chinesetheoromcalculator;

public final class Calculator {

    private int m, m1, m2, m3;
    private int M1, M2, M3;
    private int X1, X2, X3;
    private int a1, a2, a3;

    public boolean isValidResults() {
        return isValidResults;
    }

    private int tempResult;
    boolean isValidResults = false;

    public Calculator() {
    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getX1() {
        return X1;
    }

    public int getX2() {
        return X2;
    }

    public int getX3() {
        return X3;
    }

    public float getM1Big() {
        return this.M1;
    }

    public float getM2Big() {
        return this.M2;
    }

    public float getM3Big() {
        return this.M3;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getM3() {
        return m3;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public int getA3() {
        return a3;
    }

    public void setA3(int a3) {
        this.a3 = a3;
    }

    public void setM3(int m3) {
        this.m3 = m3;
    }

    public int getM() {
        return m;
    }

    public Results getResults() {
        Results results = new Results();
        int result = calculate();

        if (result == 0) {
            return results;
        }

        results.setaInfo("a1= " + a1 + ", a2= " + a2 + ", a3= " + a3);

        results.setmSmallInfo("m1= " + m1 + ", m2= " + m2 + ", m3= " + m3);

        results.setmInfo(" m = " + m1 + " * " + m2 + " * " + m3 + " = " + m);

        results.setmBigInfo("M1 = " + m + "/" + m1 + " = " + M1 +
                System.lineSeparator() + "M2 = " + m + "/" + m2 + " = " + M2 +
                System.lineSeparator() + "M3 = " + m + "/" + m3 + " = " + M3);

        results.setX0Info("X0 = " + X1 + "*" + a1 + "*" + M1
                + " + " + X2 + "*" + a2 + "*" + M2
                + " + " + X3 + "*" + a3 + "*" + M3 + " = " + this.tempResult);

        results.setFirstCalc(M1 + "X1 ☰ 1(mod" + m1 + ") => X1=" + X1);

        results.setSecCalc(M2 + "X2 ☰ 1(mod" + m2 + ") => X2=" + X2);

        results.setThirdCalc(M3 + "X3 ☰ 1(mod" + m3 + ") => X3=" + X3);

        if (this.tempResult != result) {
            results.setFinalResult(this.tempResult + "(mod" + m + ") => " + result + "(mod" + m + ")");
        }
        else {
            results.setFinalResult(result + "(mod" + m + ")");
        }

        return results;
    }

    private int calculate() {

        if (this.m1 == 0 || this.m2 == 0 || this.m3 == 0) {
            return 0;
        }

        this.m = m1 * m2 * m3;
        this.M1 = m / m1;
        this.M2 = m / m2;
        this.M3 = m / m3;

        this.X1 = getX(this.M1, m1);
        // System.out.println("GOT X1: " + X1);
        this.X2 = getX(this.M2, m2);
        //  System.out.println("GOT X2: " + X2);
        this.X3 = getX(this.M3, m3);
        // System.out.println("GOT X3: " + X3);

        int result = (int) ((this.X1 * this.a1 * this.M1)
                + (this.X2 * this.a2 * this.M2)
                + (this.X3 * this.a3 * this.M3));

        this.tempResult = result;

        if (m < result) {
            result = (int) (result % m);
        }

        this.isValidResults = true;
        //System.out.println("result: " + result + " MOD " + m);
        return result;
    }

    private int getX(float M, int mSmall) {
        int i;
        float remainder;
        int value = 0;
        for (i = 1; i < mSmall; i++) {
            remainder = (float) (M * i % mSmall);
            if (remainder == 1) {
                value = i;
            }
        }
        return value;
    }

    public void reset() {
        this.m = 0;
        this.m1 = 0;
        this.m2 = 0;
        this.m3 = 0;
        this.M1 = 0;
        this.M2 = 0;
        this.M3 = 0;
        this.X1 = 0;
        this.X2 = 0;
        this.X3 = 0;
        tempResult = 0;
        this.isValidResults = false;
    }
}
