package com.project.dm.loanorigination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import com.myspace.loanorigination.Person;

public class RuleTestRemote {
	
	private static final String containerName = "testProject";
	private static final String sessionName = "myStatelessSession";
	
	
	public static void main(String[] args) {
		
		 Set<Class<?>> allClasses = new HashSet<Class<?>>();
	      allClasses.add(Person.class);
	      String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	      String username = "wbadmin";
	      String password = "wbadmin";
	      KieServicesConfiguration config =
	        KieServicesFactory.newRestConfiguration(serverUrl,
	                                                username,
	                                                password);
	      config.setMarshallingFormat(MarshallingFormat.JAXB);
	      config.addExtraClasses(allClasses);
	      KieServicesClient kieServicesClient =
	        KieServicesFactory.newKieServicesClient(config);
	        Person p = new Person();
	        
	        p.setName("Balaji");
	        p.setAddress("Singapore");
	        p.setAge(Integer.valueOf(42));
	     
	     // Insert Person into the session:
	        KieCommands kieCommands = KieServices.Factory.get().getCommands();
	        List<Command> commandList = new ArrayList<Command>();
	        commandList.add(kieCommands.newInsert(p, "personReturnId"));
	        
	        commandList.add(kieCommands.newFireAllRules("numberOfFiredRules"));
	        BatchExecutionCommand batch = kieCommands.newBatchExecution(commandList, sessionName);
	        
	        // Use rule services client to send request:
	        RuleServicesClient ruleClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
	        ServiceResponse<ExecutionResults> executeResponse = ruleClient.executeCommandsWithResults(containerName, batch);
	        System.out.println("Rule Execution....");
	        //System.out.println("number of fired rules:" + executeResponse.getResult().getValue("numberOfFiredRules"));

		
	}
}
