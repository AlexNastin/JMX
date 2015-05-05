package jmx.test;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class SimpleAgent {

    private MBeanServer mbs = null;

    public SimpleAgent() {
        // �������� ��������� MBeanServer
        mbs = ManagementFactory.getPlatformMBeanServer();

        // ������� ��� MBean
        Hello helloBean = new Hello();
        ObjectName helloName = null;

        try {
            // � ������������ ��� �� ��������� MBeanServer 
            helloName = new ObjectName("SimpleAgent:name=hellothere");
            mbs.registerMBean(helloBean, helloName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ��� ��������������� ����� � �� ��������� ����� ��������� 
    // ������������ � �����
    private static void waitForEnterPressed() {
        try {
            System.out.println("Press  to continue...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String argv[]) {
        SimpleAgent agent = new SimpleAgent();
        System.out.println("SimpleAgent is running...");
        SimpleAgent.waitForEnterPressed();
    }
}