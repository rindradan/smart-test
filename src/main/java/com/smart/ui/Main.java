package com.smart.ui;

import com.smart.model.Frame;
import com.smart.services.calcul.CalculService;
import com.smart.services.frame.FrameFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

        CalculService calculService = (CalculService) applicationContext.getBean("calculService");
        FrameFactory frameFactory = (FrameFactory) applicationContext.getBean("frameFactory");
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        for(Frame frame : frameFactory.getFrameMap().values())
        {
            System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 1 :");
            int first = scanner.nextInt();
            calculService.setThrowKeelValueForFrame(first, 1, frame, frameFactory);

            if (first < 15)
            {
                System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 2 :");
                int second = scanner.nextInt();
                calculService.setThrowKeelValueForFrame(second, 2, frame, frameFactory);

                if (first+second < 15)
                {
                    System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 3 :");
                    int third = scanner.nextInt();
                    calculService.setThrowKeelValueForFrame(third, 3, frame, frameFactory);
                }

            }
            if (frame.getIndex() == 5)
            {
                if (frameFactory.getFrameMap().get(3).getFirst() == 15)
                {
                    if (frame.getSecond() == 0)
                    {
                        System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 2 :");
                        int second = scanner.nextInt();
                        calculService.setThrowKeelValueForFrame(second, 2, frame, frameFactory);
                    }
                }
                if (frameFactory.getFrameMap().get(4).getFirst() == 15)
                {
                    if (frame.getSecond() == 0)
                    {
                        System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 2 :");
                        int second = scanner.nextInt();
                        calculService.setThrowKeelValueForFrame(second, 2, frame, frameFactory);
                    }

                    if (frame.getThird() == 0)
                    {
                        System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 3 :");
                        int third = scanner.nextInt();
                        calculService.setThrowKeelValueForFrame(third, 3, frame, frameFactory);
                    }
                }
                if (frameFactory.getFrameMap().get(5).getFirst() == 15)
                {
                    System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 2 :");
                    int second = scanner.nextInt();
                    calculService.setThrowKeelValueForFrame(second, 2, frame, frameFactory);

                    System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 3 :");
                    int third = scanner.nextInt();
                    calculService.setThrowKeelValueForFrame(third, 3, frame, frameFactory);

                    System.out.println("Enter keel for FRAME " + frame.getIndex() + ", THROW 4 :");
                    int fourth = scanner.nextInt();
                    calculService.setThrowKeelValueForFrame(fourth, 4, frame, frameFactory);
                }
            }

        }

        totalScore = calculService.getTotalScore(frameFactory);

        System.out.println("\n");
        System.out.println("Total is : "+ totalScore);
    }
}
