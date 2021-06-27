package com.manning.liveproject.dg.liveproject.pastries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import domain.pastries.PastryDto;
import domain.pastries.PastryServicePort;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = PastriesController.class)
class PastriesControllerTest {

    private WebClient webClient;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PastryServicePort pastryServicePort;

    @BeforeEach
    void setUp() {
        this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
    }

    @Test
    @DisplayName("index page returns the landing page")
    void returnsLandingPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
    }

    @Test
    @DisplayName("index page return a list of items from the database")
    void returnsListOfItemsFromDb() throws Exception {
        final String expectedTitle = "Red Velvet";
        mockItems(expectedTitle, 3.0);

        HtmlPage page = webClient.getPage("http://localhost:8080/");
        assertThat(page.querySelectorAll(".item-title")).anyMatch(domElement -> expectedTitle.equals(domElement.getTextContent()));
    }

    private void mockItems(String title, double price) {
        when(pastryServicePort.getPastries()).thenReturn(Collections.singletonList(new PastryDto(1L, "abbr", title, price)));
    }
}