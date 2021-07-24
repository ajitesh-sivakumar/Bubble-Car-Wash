package com.ajitesh.Bubble.Car.Wash.repo;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ajitesh.Bubble.Car.Wash.bean.Wash;

@Repository
@Transactional
public interface CarWashRepository extends JpaRepository<Wash, String> {
	
	@Query(value="SELECT * FROM bcw WHERE date = :date", nativeQuery = true)
	public List<Wash> findByDate(@Param(value = "date") LocalDate date);

	@Query(value="SELECT * FROM bcw WHERE registration = :regn", nativeQuery = true)
	public List<Wash> findByRegistration(@Param(value="regn") String registration);
}
