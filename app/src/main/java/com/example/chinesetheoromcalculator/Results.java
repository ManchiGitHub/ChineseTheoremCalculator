package com.example.chinesetheoromcalculator;

public class Results {

    public Results() {
    }

    public Results(String aInfo, String mSmallInfo, String mInfo, String mBigInfo, String calculations, String x0Info) {
        this.aInfo = aInfo;
        this.mSmallInfo = mSmallInfo;
        this.mInfo = mInfo;
        this.mBigInfo = mBigInfo;
        this.calculations = calculations;
        this.x0Info = x0Info;
    }

    private String aInfo; // a1, a2, a3
    private String mSmallInfo; // m1, m2, m3
    private String mInfo; // m
    private String mBigInfo; // M1, M2, M3
    private String calculations;
    private String x0Info;
    private String finalResult;

    public String getFinalResult() {
        return finalResult;
    }

    public String getFirstCalc() {
        return firstCalc;
    }

    public String getSecCalc() {
        return secCalc;
    }

    public String getThirdCalc() {
        return thirdCalc;
    }

    private String firstCalc;
    private String secCalc;
    private String thirdCalc;

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public void setFirstCalc(String firstCalc) {
        this.firstCalc = firstCalc;
    }

    public void setSecCalc(String secCalc) {
        this.secCalc = secCalc;
    }

    public void setThirdCalc(String thirdCalc) {
        this.thirdCalc = thirdCalc;
    }

    public String getaInfo() {
        return aInfo;
    }

    public void setaInfo(String aInfo) {
        this.aInfo = aInfo;
    }

    public String getmSmallInfo() {
        return mSmallInfo;
    }

    public void setmSmallInfo(String mSmallInfo) {
        this.mSmallInfo = mSmallInfo;
    }

    public String getmInfo() {
        return mInfo;
    }

    public void setmInfo(String mInfo) {
        this.mInfo = mInfo;
    }

    public String getmBigInfo() {
        return mBigInfo;
    }

    public void setmBigInfo(String mBigInfo) {
        this.mBigInfo = mBigInfo;
    }

    public String getCalculations() {
        return calculations;
    }

    public void setCalculations(String calculations) {
        this.calculations = calculations;
    }

    public String getX0Info() {
        return x0Info;
    }

    public void setX0Info(String x0Info) {
        this.x0Info = x0Info;
    }
}
