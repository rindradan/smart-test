package com.smart.services.count.impl;

import com.smart.model.Frame;
import com.smart.services.count.CountService;
import com.smart.services.frame.FrameFactory;

public class CountServiceImpl implements CountService
{
    private FrameFactory frameFactory;

    @Override
    public int getFrameScore(Frame frame)
    {
        return frame.getFirst() + frame.getSecond() + frame.getThird() + frame.getFourth();
    }

    @Override
    public int getTotalScore()
    {
        int total = 0;

        for (Frame frame : frameFactory.getFrameMap().values())
        {
            if (getFrameScore(frame) < 15)
            {
                total += getFrameScore(frame);
                System.out.println("FRAME "+ frame.getIndex() +" score is : "+ getFrameScore(frame) +"\n");
            }
            else
            {
                if (frame.getFirst() == 15)
                {
                    System.out.println("FRAME " + frame.getIndex());
                    int frameStrikeScore = getStrike(frame, 3);
                    total += frameStrikeScore;
                    System.out.println("FRAME "+ frame.getIndex() +" score is : "+ frameStrikeScore +"\n");
                }
                else
                {
                    int frameSpareScore = getSpare(frame, 2);
                    total += frameSpareScore;
                    System.out.println("FRAME "+ frame.getIndex() +" score is : "+ frameSpareScore +"\n");
                }
            }
        }

        return total;
    }

    @Override
    public int getStrike(Frame frame, int coolDown)
    {
        System.out.println("getStrike for FRAME coolDown="+ coolDown);
        int totalStrike = 0;

        totalStrike += frame.getFirst();

        if (coolDown == 0)
        {
            System.out.println("return total="+ totalStrike +" for the FRAME");
            return totalStrike;
        }
        else
        {
            totalStrike += checkNext(frame, coolDown);
        }

        return totalStrike;
    }

    @Override
    public int getSpare(Frame frame, int coolDown)
    {
        int totalSpare = getFrameScore(frame);

        totalSpare += checkNext(frame, coolDown);

        return totalSpare;
    }

    @Override
    public int checkNext(Frame frame, int coolDown)
    {
        int totalNext = 0;

        Frame next = frameFactory.getFrameMap().get(frame.getIndex()+1);
        if (next == null)
        {
            if (coolDown == 1)
            {
                totalNext += frame.getSecond();
            }
            else if (coolDown == 2)
            {
                totalNext += frame.getSecond();
                totalNext += frame.getThird();
            }
            else if (coolDown == 3)
            {
                totalNext += frame.getSecond();
                totalNext += frame.getThird();
                totalNext += frame.getFourth();
            }
        }
        else
        {
            if (next.getFirst() == 15)
            {
                totalNext += getStrike(next, --coolDown);
            }
            else
            {
                int sumOfNext = next.getFirst() + next.getSecond();
                totalNext += sumOfNext;

                if (coolDown == 3)
                {
                    if (sumOfNext == 15)
                    {
                        totalNext += getStrike(next, 0);
                    }
                    else
                    {
                        totalNext += next.getThird();
                    }
                }
            }
        }
        return totalNext;
    }

    public FrameFactory getFrameFactory()
    {
        return frameFactory;
    }

    public void setFrameFactory(FrameFactory frameFactory)
    {
        this.frameFactory = frameFactory;
    }
}
