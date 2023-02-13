package com.example.demo.Controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.Local;
import com.example.demo.domain.Park;
import com.example.demo.dto.NearestParkDto;
import com.example.demo.dto.ParkResponseDto;
import com.example.demo.service.ParkService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;

@WebMvcTest
public class ParkControllerTest {
    @MockBean
    private ParkService parkService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("api/v1/parks/{parkID} 호출응답 테스트")
    @WithMockUser(roles = {"USER"})
    public void GetByParkid() throws Exception {
        //given
        Park park = createPark("TEST");
        ReflectionTestUtils.setField(park,"id",1L);
        ParkResponseDto parkResponseDto = new ParkResponseDto();
        parkResponseDto.toParkResponseDto(park);
        given(parkService.findOne(1L)).willReturn(parkResponseDto);
        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/parks/" + 1L).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        //then
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo("{\"id\":1,\"name\":\"TEST\",\"address\":\"TEST ADDR DETAIL\",\"content\":\"TEST CONTENT\",\"lastModifiedTime\":null}");
    }

    @Test
    @DisplayName("api/v1/parks/nearest 호출응답 테스트")
    @WithMockUser(roles = {"USER"})
    public void GetNearestPark() throws Exception {
        //given
        Local Test_Local = new Local("Test Name",1d,1d);
        NearestParkDto nearestParkDto = new NearestParkDto(1L,"TESTNAME",2d,2d);
        given(parkService.findNearestPark(Test_Local.getX_pos(),Test_Local.getY_pos())).willReturn(nearestParkDto);

        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/parks/nearest")
                        .param("x","1")
                        .param("y","1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn()
                        .getResponse();
        //then
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo("{\"id\":1,\"name\":\"TESTNAME\",\"x_pos\":2.0,\"y_pos\":2.0}");
    }
    private Park createPark(String name)
    {
        String testname=name;
        Local local= new Local("TESTNAME",1.0,1.0);
        Address address= new Address("TEST ADDR DETAIL");
        String content="TEST CONTENT";
        LocalDateTime localDate = null;
        return new Park(name,local,address,content,localDate);
    }
}
