package com.smart.services.calcul;

import com.smart.model.Frame;
import com.smart.services.BaseServiceTest;
import com.smart.services.frame.FrameFactory;

import java.util.Scanner;

public class CalculServiceTest extends BaseServiceTest
{
    public void testLancer()
    {
        CalculService calculService = (CalculService) getApplicationContext().getBean("calculService");
        FrameFactory frameFactory = (FrameFactory) getApplicationContext().getBean("frameFactory");
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        for(Frame frame : frameFactory.getFrameMap().values())
        {
            System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 1 :");
            int first = scanner.nextInt();
            calculService.setThrowKeelValueForFrame(first, 1, frame, frameFactory);

            System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 2 :");
            int second = scanner.nextInt();
            calculService.setThrowKeelValueForFrame(second, 2, frame, frameFactory);

            System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 3 :");
            int third = scanner.nextInt();
            calculService.setThrowKeelValueForFrame(third, 3, frame, frameFactory);

        }

        totalScore = calculService.getTotalScore(frameFactory);

        System.out.println("\n");
        System.out.println("Total is : "+ totalScore);

    }

}
