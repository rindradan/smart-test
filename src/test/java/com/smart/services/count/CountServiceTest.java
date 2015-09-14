package com.smart.services.count;

import com.smart.model.Frame;
import com.smart.services.BaseServiceTest;
import com.smart.services.frame.FrameFactory;

public class CountServiceTest extends BaseServiceTest
{
    public void testCountService()
    {
        CountService countService = (CountService) getApplicationContext().getBean("countService");
        FrameFactory frameFactory = (FrameFactory) getApplicationContext().getBean("frameFactory");
        int total = 0;

        Frame frame1 = frameFactory.getFrameMap().get(1);
        frame1.setFirst(8);
        System.out.println("FRAME " + frame1.getIndex() + ", THROW 1 : "+ frame1.getFirst());
        frame1.setSecond(1);
        System.out.println("FRAME " + frame1.getIndex() + ", THROW 2 : "+ frame1.getSecond());
        frame1.setThird(1);
        System.out.println("FRAME " + frame1.getIndex() + ", THROW 3 : "+ frame1.getThird());

        Frame frame2 = frameFactory.getFrameMap().get(2);
        frame2.setFirst(8);
        System.out.println("FRAME " + frame2.getIndex() + ", THROW 1 : "+ frame2.getFirst());
        frame2.setSecond(7);
        System.out.println("FRAME " + frame2.getIndex() + ", THROW 2 : "+ frame2.getSecond());

        Frame frame3 = frameFactory.getFrameMap().get(3);
        frame3.setFirst(1);
        System.out.println("FRAME " + frame3.getIndex() + ", THROW 1 : "+ frame3.getFirst());
        frame3.setSecond(2);
        System.out.println("FRAME " + frame3.getIndex() + ", THROW 2 : "+ frame3.getSecond());
        frame3.setThird(1);
        System.out.println("FRAME " + frame3.getIndex() + ", THROW 1 : " + frame3.getThird());

        Frame frame4 = frameFactory.getFrameMap().get(4);
        frame4.setFirst(15);
        System.out.println("FRAME " + frame4.getIndex() + ", THROW 1 : " + frame4.getFirst());

        Frame frame5 = frameFactory.getFrameMap().get(5);
        frame5.setFirst(1);
        System.out.println("FRAME " + frame5.getIndex() + ", THROW 1 : " + frame5.getFirst());
        frame5.setSecond(2);
        System.out.println("FRAME " + frame5.getIndex() + ", THROW 2 : " + frame5.getSecond());
        frame5.setThird(1);
        System.out.println("FRAME " + frame5.getIndex() + ", THROW 3 : " + frame5.getThird());

        System.out.println("");

        total += countService.getTotalScore();

        System.out.println("\n");
        System.out.println("Total is : "+ total);
    }

    public void testStrikes()
    {
        CountService countService = (CountService) getApplicationContext().getBean("countService");
        FrameFactory frameFactory = (FrameFactory) getApplicationContext().getBean("frameFactory");
        int total = 0;

        for (Frame frame : frameFactory.getFrameMap().values())
        {
            frame.setFirst(15);
            System.out.println("FRAME " + frame.getIndex() + ", THROW 1 : "+ frame.getFirst());
        }

        Frame frame5 = frameFactory.getFrameMap().get(5);
        frame5.setSecond(15);
        frame5.setThird(15);
        frame5.setFourth(15);

        System.out.println("");

        total += countService.getTotalScore();

        System.out.println("\n");
        System.out.println("Total is : "+ total);
    }
}
