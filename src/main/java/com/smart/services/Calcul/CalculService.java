package com.smart.services.calcul;

import com.smart.model.Frame;
import com.smart.services.frame.FrameFactory;

public interface CalculService
{
    public int setThrowKeelValueForFrame(int keelValue, int indexThrow, Frame frame, FrameFactory frameFactory);
    public int setStrikeForFrame(Frame frame, FrameFactory frameFactory);
    public int getScoreFrom(Frame frame);
    public int getTotalScore(FrameFactory frameFactory);
}
