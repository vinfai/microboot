package com.vinfai;

import com.vinfai.entity.UserInfo;
import com.vinfai.mapper.UserInfoMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicrobootMybatisApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class MicrobootMybatisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	UserInfoMapper dao;

	@Test
	public void getUserInfoById() {
		UserInfo userInfo = dao.getUserById(3);
		System.out.println(userInfo);
	}


	@Test
	public void insert() {
		dao.insert(new UserInfo(2, "jack2", "pwd2"));
		dao.insert(new UserInfo(3, "jack3", "pwd3"));
		dao.insert(new UserInfo(4, "jack4", "pwd4"));

		Assert.assertEquals(4, dao.getAll().size());

	}

}
