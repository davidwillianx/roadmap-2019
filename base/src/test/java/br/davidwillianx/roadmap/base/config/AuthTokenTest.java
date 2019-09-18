package br.davidwillianx.roadmap.base.config;


import br.davidwillianx.roadmap.base.configuration.InitializationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = InitializationConfig.class
)
@AutoConfigureMockMvc
public class AuthTokenTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("user@test.com")
    public void shouldAllowRequestBasedOnExistentAuthorities() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/i")
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldUnauthorizeResquetBasedOnNoExistenceToken() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/i")
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isUnauthorized());
    }
}
