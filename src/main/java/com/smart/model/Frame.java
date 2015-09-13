package com.smart.model;

public class Frame
{
    private int index;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private String state;

    public Frame(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getFirst()
    {
        return first;
    }

    public void setFirst(int first)
    {
        this.first = first;
    }

    public int getSecond()
    {
        return second;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }

    public int getThird()
    {
        return third;
    }

    public void setThird(int third)
    {
        this.third = third;
    }

    public int getFourth()
    {
        return fourth;
    }

    public void setFourth(int fourth)
    {
        this.fourth = fourth;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
