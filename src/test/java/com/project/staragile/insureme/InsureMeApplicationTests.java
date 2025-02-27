package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsureMeApplicationTests {
	
	@Autowired
	PolicyRepository policyRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreatePolicy() {
		Policy policy = new Policy(1, "Vikul", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService();
		//Policy outputPolicy = pService.CreatePolicy();
		assertEquals(policy.getPolicyId(), pService.generateDummyPolicy().getPolicyId());
		
	}
	
	@Test
	void testSearchPolicy() {
		PolicyService pService = new PolicyService();
		assertEquals(null,pService.searchPolicy());
	}
	
	
	@Test
	void testDeletePolicy() {
		Policy policy = new Policy(1, "Jordan", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService();
		pService.policyRepository = policyRepository;
		pService.registerPolicy(policy);
		String expected = "Deleted Successfully";
		assertEquals(expected, pService.deletePolicy(1));

	}
	
	@Test
	void testViewPolicy() {
		Policy policy = new Policy(2, "For View", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService();
		pService.policyRepository = policyRepository;
		pService.registerPolicy(policy);
		assertEquals(policy.getPolicyHolderName(), pService.getPolicyDetails(2).getPolicyHolderName());

	}
	@Test
	void testUpdatePolicy() {
		Policy policy = new Policy(1, "For View", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService();
		pService.policyRepository = policyRepository;
		pService.registerPolicy(policy);
		Policy updatedPolicy = new Policy(1, "updated", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		assertEquals(updatedPolicy.getPolicyHolderName(), pService.updatePolicy(updatedPolicy, 1).getPolicyHolderName());

	}


	
}
