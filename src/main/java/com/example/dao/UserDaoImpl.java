package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int create(UserVo user) {
		return this.sqlSession.insert("User.insertUser", user);
	}

	@Override
	public UserVo read(String userid) {
		return this.sqlSession.selectOne("User.selectUser", userid);
	}

	@Override
	public List<UserVo> readAll() {
		return this.sqlSession.selectList("User.selectAllUsers");
	}

	@Override
	public int update(UserVo user) {
		return this.sqlSession.update("User.updateUser", user);
	}

	@Override
	public int delete(String userid) {
		return this.sqlSession.delete("User.deleteUser", userid);
	}
}
