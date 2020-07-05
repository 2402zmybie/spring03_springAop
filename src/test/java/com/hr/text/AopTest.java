package com.hr.text;


import com.hr.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService iAccountService = ac.getBean("accountService",IAccountService.class);

        iAccountService.saveAccount();

        iAccountService.updateAccount(2);

        iAccountService.deleteAccount();
    }
}
