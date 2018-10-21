package com.devglan.userportal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private UserService userService;
	
	@Autowired
    WebApplicationContext wac;
	
	/*@Before
	public void before() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
	}*/
	
	@Test
	public void create() throws Exception {
		User mocUser= new User();
		mocUser.setFirstName("praveennn");
		mocUser.setLastName("test");
		mocUser.setEmail("praveen.sule@gmail.com");
		
		ObjectMapper mapper = new ObjectMapper();
		String value = mapper.writeValueAsString(mocUser);
		System.out.println(value);
		Mockito.when(
				userService.create(Mockito.any(User.class))).thenReturn(mocUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/user-portal/api").content(value)
				.contentType(MediaType.APPLICATION_JSON);


		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		System.out.println(response.getContentAsString());
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}
}
