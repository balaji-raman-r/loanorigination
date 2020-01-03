package com.project.dm.loanorigination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myspace.loanorigination.Person;

public class BlackListVerification {
    static final Logger LOG = LoggerFactory.getLogger(BlackListVerification.class);

   
    public static void main (String[] args){
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kContainer = kieServices.getKieClasspathContainer();
        Results verifyResults = kContainer.verify();
        for (Message m : verifyResults.getMessages()) {
            LOG.info("{}", m);
            System.out.println("m...."+ m);
        }

        LOG.info("Creating kieBase");
        KieBase kieBase = kContainer.getKieBase();

        LOG.info("There should be rules: ");
        for ( KiePackage kp : kieBase.getKiePackages() ) {
            for (Rule rule : kp.getRules()) {
                LOG.info("kp " + kp + " rule " + rule.getName());
                System.out.println("Rule Name:"+ rule.getName());
            }
        }

        LOG.info("Creating kieSession");
        KieSession session = kieBase.newKieSession();

        LOG.info("Populating globals");
        Set<String> check = new HashSet<String>();
       // session.setGlobal("controlSet", check);

        LOG.info("Now running data");
        
        
        LoanApplication loanApplication = new LoanApplication();
        
        
        
        Applicant applicant = new Applicant();
        
        applicant.setName("John Smith");
        applicant.setUniqueId("1111");
        applicant.setDateOfBirth(new Date(1995, 5, 22));
        Employment employment = new Employment();
        employment.setEmploymentType(EmploymentType.SALARIED);
        employment.setIncome(new BigDecimal(20000));
        applicant.setEmployment(employment);
        applicant.setNoOfPreviousDefaults(2);
        
       
        
        loanApplication.setApplicant(applicant);
        loanApplication.setLoanAmount(new BigDecimal (10000));
        loanApplication.setTenure(10);
        loanApplication.setRemarks("check");

        // Insert the person into the session:
        session.insert(loanApplication);

        // Fire all rules:
        session.fireAllRules();
        System.out.println("Rule Executed.....Application Status:"+loanApplication.getStatus());
        System.out.println("CreditScore: "+ applicant.getCreditScore());
        System.out.println("Remarks:"+loanApplication.getRemarks());
      
        session.dispose();
        
  
    }
}
