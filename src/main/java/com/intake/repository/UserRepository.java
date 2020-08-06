package com.intake.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.intake.model.db.UserProfile;

public class UserRepository implements CrudRepository<UserProfile, Integer> {

	@Override
	public <S extends UserProfile> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserProfile> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserProfile> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<UserProfile> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserProfile> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserProfile entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UserProfile> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
