package com.example.demo.repository;

import com.example.demo.domain.Address;
import com.example.demo.domain.Local;
import com.example.demo.domain.Park;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


//@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Repository.class))
@SpringBootTest
@Transactional
class ParkRepositoryTest {
    @Autowired
    private ParkRepository parkRepository;

    private Local local = new Local("TESTNAME",1d,1d);
    private Address address = address = new Address("TEST ADDR NAMEDETAIL");;
    private String content = "TESTCONTENT";
    //CRUD -> Create, Read, Update, Delete
    @Test
    @DisplayName("CREATE 기능 테스트")
    void save() {
        //given
        Park entity = createEntity("TEST");
        ReflectionTestUtils.setField(entity,"contentId","TEST");

        //when
        Park save = parkRepository.save(entity);

        //then
        Assertions.assertThat(save).isNotNull();
        Assertions.assertThat(save.getId()).isEqualTo(entity.getId());
    }
    @Test
    @DisplayName("단건 조회 기능 테스트")
    void findParkInfoById() {
        //given
        Park entity1 = createEntity("TEST");
        ReflectionTestUtils.setField(entity1,"contentId","TEST1");
        Park entity2 = createEntity("TEST2");
        ReflectionTestUtils.setField(entity2,"contentId","TEST2");
        Park entity3 = createEntity("TEST3");
        ReflectionTestUtils.setField(entity3,"contentId","TEST3");
        Park save1 = parkRepository.save(entity1);
        Park save2 = parkRepository.save(entity2);
        Park save3 = parkRepository.save(entity3);

        //when
        Optional<Park> findOne = parkRepository.findParkInfoById(1L);
        Optional<Park> findTwo = parkRepository.findParkInfoById(2L);
        Optional<Park> findThree = parkRepository.findParkInfoById(3L);
        Optional<Park> findNotExist = parkRepository.findParkInfoById(4L);

        //then
        Assertions.assertThat(findOne).isNotNull();
        Assertions.assertThat(findTwo).isNotNull();
        Assertions.assertThat(findThree).isNotNull();
        Assertions.assertThat(findNotExist.isEmpty()).isTrue();
        Assertions.assertThat(findOne.get().getId()).isEqualTo(entity1.getId());
    }
    @Test
    @DisplayName("모든 Entity 조회 기능 테스트")
    void findAll() {
        //given
        Park entity1 = createEntity("TEST");
        ReflectionTestUtils.setField(entity1,"contentId","TEST1");
        Park entity2 = createEntity("TEST2");
        ReflectionTestUtils.setField(entity2,"contentId","TEST2");
        Park entity3 = createEntity("TEST3");
        ReflectionTestUtils.setField(entity3,"contentId","TEST3");
        Park save1 = parkRepository.save(entity1);
        Park save2 = parkRepository.save(entity2);
        Park save3 = parkRepository.save(entity3);
        //when
        List<Park> findAll = parkRepository.findAll();

        //then
        Assertions.assertThat(findAll.size()).isEqualTo(3);
        Assertions.assertThat(findAll.get(0).getId()).isEqualTo(entity1.getId());
        Assertions.assertThat(findAll.get(0).getName()).isEqualTo(entity1.getName());
    }
    private Park createEntity(String name)
    {
        return new Park(name,local,address,content,null);
    }
}