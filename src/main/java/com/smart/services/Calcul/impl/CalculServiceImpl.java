package com.smart.services.calcul.impl;

import com.smart.model.Frame;
import com.smart.services.calcul.CalculService;
import com.smart.services.frame.FrameFactory;

public class CalculServiceImpl implements CalculService
{
    @Override
    public int setThrowKeelValueForFrame(int keelValue, int indexThrow, Frame frame, FrameFactory frameFactory)
    {
        switch (indexThrow)
        {
            case 1 :
                frame.setFirst(keelValue);
                break;

            case 2 :
                frame.setSecond(keelValue);
                break;

            case 3 :
                frame.setThird(keelValue);
                break;

            case 4 :
                frame.setFourth(keelValue);
                break;

            default : break;
        }

        int totalScore = getTotalScore(frameFactory);

        System.out.println("Frame "+ frame.getIndex() +", Throw "+ indexThrow +" => Total is : " + totalScore);

        return totalScore;
    }

    @Override
    public int setStrikeForFrame(Frame frame, FrameFactory frameFactory)
    {
        frame.setState("x");
        return 0;
    }

    @Override
    public int getScoreFrom(Frame frame)
    {
        return frame.getFirst() + frame.getSecond() + frame.getThird() + frame.getFourth();
    }

    @Override
    public int getTotalScore(FrameFactory frameFactory)
    {
        int total = 0;

        for(Frame frame : frameFactory.getFrameMap().values())
        {
            total += frame.getFirst();

            if(frame.getFirst() == 15)
            {
                try
                {
                    Frame next = frameFactory.getFrameMap().get(frame.getIndex()+1);
                    total += next.getFirst();

                    try
                    {
                        Frame nextOfnext = frameFactory.getFrameMap().get(frame.getIndex()+2);

                        if(next.getFirst() == 15)
                        {
                            total += nextOfnext.getFirst();

                            try
                            {
                                Frame nextOfnextOfnext = frameFactory.getFrameMap().get(frame.getIndex()+3);

                                if (nextOfnext.getFirst() == 15)
                                {
                                    total += nextOfnextOfnext.getFirst();
                                }
                                else
                                {
                                    total += nextOfnext.getSecond();
                                }
                            }
                            catch (NullPointerException e)
                            {
                                total += nextOfnext.getSecond();
                            }
                        }
                        else
                        {
                            total += next.getSecond();

                            if (next.getSecond() == 15)
                            {
                                total += nextOfnext.getFirst();
                            }
                            else
                            {
                                total += next.getThird();
                            }
                        }
                    }
                    catch (NullPointerException e)
                    {
                        total += next.getSecond();
                        total += next.getThird();
                    }
                }
                catch (NullPointerException e)
                {
                    total += frame.getSecond();
                    total += frame.getThird();
                    total += frame.getFourth();
                }

            }
            else
            {
                total += frame.getSecond();
                total += frame.getThird();

                if (frame.getSecond() == 15 || frame.getThird() == 15)
                {
                    total += frame.getFourth();
                }
            }

            if (frame.getIndex() != 1)
            {
                Frame prev = frameFactory.getFrameMap().get(frame.getIndex()-1);
                int totalFrame = getScoreFrom(prev);
                if(prev.getFirst() != 15 && totalFrame == 15)
                {
                    if (frame.getIndex() != 5)
                    {
                        total += frameFactory.getFrameMap().get(frame.getIndex()).getFirst();

                        if (frameFactory.getFrameMap().get(frame.getIndex()).getFirst() == 15)
                        {
                            total += frameFactory.getFrameMap().get(frame.getIndex()+1).getFirst();
                        }
                        else
                        {
                            total += frameFactory.getFrameMap().get(frame.getIndex()).getSecond();
                        }
                    }
                    else
                    {
                        total += frame.getSecond();
                        total += frame.getThird();
                    }
                }
            }

        }

        return total;
    }
}
