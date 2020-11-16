
package ee.bcs.valiiit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test

public class AccountServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registrationWorksThroughAllLayers() throws Exception {

        mockMvc.perform(get("/bank/checkAccounts")
                .contentType("application/json"))
                .andExpect(status().isOk())
                //.andExpect(content().string(containsString("EE0001")));
                .andExpect(content().string(containsString("EE0001")));
    }

}
