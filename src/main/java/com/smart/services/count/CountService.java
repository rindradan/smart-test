package com.smart.services.count;

import com.smart.model.Frame;
import com.smart.services.frame.FrameFactory;

public interface CountService
{
    public int getFrameScore(Frame frame);
    public int getTotalScore();
    public int getStrike(Frame frame, int coolDown);
    public int getSpare(Frame frame, int coolDown);
    public int checkNext(Frame frame, int coolDown);
}
