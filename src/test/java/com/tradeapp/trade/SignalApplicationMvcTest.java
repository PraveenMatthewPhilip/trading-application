package com.tradeapp.trade;

import com.tradeapp.trade.controller.SignalController;
import com.tradeapp.trade.service.SignalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SignalController.class)
class SignalApplicationMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SignalService signalService;

	@Test
	void sendController_withPostRequest_succeeds() throws Exception {
		this.mockMvc.perform(post("/signal/1")).andExpect(status().isNoContent());
	}

	@Test
	void sendController_withGetRequest_fails() throws Exception {
		this.mockMvc.perform(get("/signal/1")).andExpect(status().is4xxClientError());
	}

}
