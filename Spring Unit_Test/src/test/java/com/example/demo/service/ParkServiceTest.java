package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Local;
import com.example.demo.domain.Park;
import com.example.demo.dto.NearestParkDto;
import com.example.demo.dto.ParkResponseDto;
import com.example.demo.repository.ParkRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
class ParkServiceTest {

    @InjectMocks
    private ParkService parkService;
    @Mock
    private ParkRepository parkRepository;

        @Test
        @DisplayName("Park Entity 추가 TEST")
        void addPark() {
            //given
            Park park = createPark("TEST");
            Long Fakeid = 1L;
            ReflectionTestUtils.setField(park,"id",Fakeid);

            //mocking
            given(parkRepository.save(park)).willReturn(park);
            given(parkRepository.findParkInfoById(Fakeid)).willReturn(Optional.of(park));

            //when
            Long saved = parkService.addPark(park);

            //then
            Park savedpark = parkRepository.findParkInfoById(saved).get();
            Assertions.assertThat(savedpark.getId()).isEqualTo(park.getId());
        }
    @Test
    @DisplayName("ID 값으로 Park Entity를 찾는 기능 TEST")
    void findOne() {
        //given
        Park park = createPark("TEST");
        Long TestId = 1L;
        ReflectionTestUtils.setField(park,"id",TestId);

        //mocking
        given(parkRepository.findParkInfoById(TestId)).willReturn(Optional.of(park));

        //when
        ParkResponseDto find = parkService.findOne(TestId);

        //then
        Assertions.assertThat(find).isNotNull();
        Assertions.assertThat(find.getId()).isEqualTo(park.getId());
    }

    @Test
    @DisplayName("모든 ParkEntity 반환 TEST")
    void findAll() {
        //given
        List<Park> parks =new ArrayList<>();
        Park park1 = createPark("TEST1");
        Park park2 = createPark("TEST2");
        Park park3 = createPark("TEST3");
        ReflectionTestUtils.setField(park1,"id",1L);
        ReflectionTestUtils.setField(park2,"id",2L);
        ReflectionTestUtils.setField(park3,"id",3L);
        parks.add(park1);
        parks.add(park2);
        parks.add(park3);
        //mocking
        given(parkRepository.findAll()).willReturn(parks);
        //when
        List<Park> finds = parkService.findAll();
        //then
        Assertions.assertThat(finds).isNotNull();
        Assertions.assertThat(finds.size()).isEqualTo(3);
        Assertions.assertThat(finds.get(0)).isEqualTo(parks.get(0));
        Assertions.assertThat(finds.get(1)).isEqualTo(parks.get(1));
        Assertions.assertThat(finds.get(2)).isEqualTo(parks.get(2));
    }
    @Test
    @DisplayName("현재 위치와 가장 가까운 주차장을 반환하는 기능 TEST")
    void findNearestPark() {
        //given
        List<Park> parks = new ArrayList<>();
        Park park1 = createParkv2("TEST1","TESTLOCAL1",1d,0d);
        Park park2 = createParkv2("TEST2","TESTLOCAL2",3d,0d);
        Park park3 =createParkv2("TEST3","TESTLOCAL3",7d,0d);
        ReflectionTestUtils.setField(park1,"id",1L);
        ReflectionTestUtils.setField(park2,"id",2L);
        ReflectionTestUtils.setField(park3,"id",3L);
        parks.add(park1);
        parks.add(park2);
        parks.add(park3);
        Local testLocal = new Local("TESTLOCAL",4d,0d);

        //mocking
        given(parkRepository.findAll()).willReturn(parks);

        //when
        NearestParkDto find = parkService.findNearestPark(testLocal.getX_pos(), testLocal.getY_pos());

        //then
        Assertions.assertThat(find).isNotNull();
        Assertions.assertThat(find.getId()).isEqualTo(park2.getId());

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
    private Park createParkv2(String name,String localname,double x,double y)
    {
        String testname=name;
        Local local= new Local(localname,x,y);
        Address address= new Address("TEST ADDR DETAIL");
        String content="TEST CONTENT";
        LocalDateTime localDate = null;
        return new Park(name,local,address,content,localDate);
    }
}