package net.codejava.spring.dao;

import static org.junit.Assert.*;
import net.codejava.spring.config.MvcConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MvcConfiguration.class})
public class ContactDAOImplTest {

	private MockMvc mockMvc;
	
	// @Autowired
	 //private WebApplicationContext webApplicationContext;
	 
	@Autowired
	private ContactDAO contactDAO;
	
	@Before
    public void setUp() {
       // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	@Test
	public void testSayHello() {
		assertEquals("Hello world!", "Hello world!");
	}
	
}
