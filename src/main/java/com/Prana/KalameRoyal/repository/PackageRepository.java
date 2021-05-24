package com.Prana.KalameRoyal.repository;

import com.Prana.KalameRoyal.domain.Package;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends MongoRepository<Package, String> {

    @Query(value = "{}", fields = "{ 'id':1, 'name':1, 'completed':1, 'modifier':1 }")
    List<Package> findIdAndNameAndAndCompleted();

    @Query(value = "{ 'id':1 }", fields = "{ 'id':1, 'name':1, 'completed':1 }")
    Package findIdAndNameAndCompletedById(String id);

    @Query(value = "{ 'id':1, 'name':1, 'completed':1 }", fields = "{ 'id':1, 'name':1, 'completed':1 }" )
    Package saveIdAndAndNameAndCompleted(Package pack);

}
